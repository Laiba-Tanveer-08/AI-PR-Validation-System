package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.dto.GithubWebhookDto;
import com.aiprteam.backend.service.GitHubService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubServiceImpl implements GitHubService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String GITHUB_API =
            "https://api.github.com/repos/";

    // =========================
    // 1. WEBHOOK VALIDATION (SIGNATURE CHECK)
    // =========================
    @Override
    public boolean validateWebhookSignature(String payload, String signature, String secret) {
        // TODO: implement HMAC SHA-256 validation
        return true; // placeholder
    }

    // =========================
    // 2. PARSE WEBHOOK
    // =========================
    @Override
    public JsonNode parseWebhook(String payload) {
        try {
            return objectMapper.readTree(payload);
        } catch (Exception e) {
            throw new RuntimeException("Invalid webhook JSON", e);
        }
    }

    // =========================
    // 3. EXTRACT REPO METADATA
    // =========================
    @Override
    public GithubWebhookDto extractRepoMetadata(JsonNode root) {

        JsonNode repo = root.path("repository");

        GithubWebhookDto dto = new GithubWebhookDto();

        dto.setGithubRepoId(repo.path("id").asLong());
        dto.setRepoName(repo.path("name").asText());
        dto.setRepoOwner(repo.path("owner").path("login").asText());
        dto.setRepoUrl(repo.path("html_url").asText());
        dto.setIsPrivate(repo.path("private").asBoolean());
        dto.setDefaultBranch(repo.path("default_branch").asText());

        return dto;
    }

    // =========================
    // 4. ACTION TYPE
    // =========================
    @Override
    public String extractAction(JsonNode root) {
        return root.path("action").asText();
    }

    // =========================
    // 5. PR NUMBER
    // =========================
    @Override
    public int extractPrNumber(JsonNode root) {
        return root.path("pull_request").path("number").asInt();
    }

    // =========================
    // 6. FETCH PR FILES FROM GITHUB API
    // =========================
    @Override
    public List<ChangedFileDto> fetchPrFiles(String owner, String repo, int prNumber) {

        String url = GITHUB_API + owner + "/" + repo + "/pulls/" + prNumber + "/files";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("User-Agent", "AI-PR-System");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return parseFiles(response.getBody());
    }

    // =========================
    // PARSE FILES
    // =========================
    private List<ChangedFileDto> parseFiles(String body) {

        List<ChangedFileDto> files = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(body);

            for (JsonNode node : root) {

                ChangedFileDto dto = new ChangedFileDto();

                dto.setFileName(node.path("filename").asText());
                dto.setFileStatus(node.path("status").asText());
                dto.setAdditions(node.path("additions").asInt());
                dto.setDeletions(node.path("deletions").asInt());
                dto.setPatch(node.path("patch").asText(""));

                files.add(dto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse PR files", e);
        }

        return files;
    }
}