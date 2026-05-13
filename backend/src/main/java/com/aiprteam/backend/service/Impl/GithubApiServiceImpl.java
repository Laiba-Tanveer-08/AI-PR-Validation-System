package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.service.GithubApiService;
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
public class GithubApiServiceImpl implements GithubApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String GITHUB_API =
            "https://api.github.com/repos/";

    @Override
    public List<ChangedFileDto> getPrFiles(String owner, String repo, int prNumber) {

        String url = GITHUB_API + owner + "/" + repo + "/pulls/" + prNumber + "/files";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("User-Agent", "AI-PR-System");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return parseFiles(response.getBody());
    }

    private List<ChangedFileDto> parseFiles(String responseBody) {

        List<ChangedFileDto> files = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(responseBody);

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
            throw new RuntimeException("Failed to parse GitHub files", e);
        }

        return files;
    }
}