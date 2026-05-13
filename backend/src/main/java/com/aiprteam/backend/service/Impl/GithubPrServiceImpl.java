package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.AIContextDto;
import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.dto.GithubPrDto;
import com.aiprteam.backend.entity.PullRequest;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.mapper.GithubPrMapper;
import com.aiprteam.backend.repository.PullRequestRepository;
import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.GithubApiService;
import com.aiprteam.backend.service.GithubPrService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
    public class GithubPrServiceImpl implements GithubPrService {

        private final ObjectMapper objectMapper = new ObjectMapper();
        private final GithubPrMapper githubPrMapper = new GithubPrMapper();

        private final PullRequestRepository pullRequestRepository;
        private final GithubApiService githubApiService;
        private final SprintRepository sprintRepository;

        @Override
        @Transactional
        public PullRequest syncPRFromGitHub(String webhookPayload) {

            JsonNode root = parseWebhook(webhookPayload);

            JsonNode prNode = root.path("pull_request");

            validatePR(prNode);

            GithubPrDto prDto = mapPullRequest(prNode, root);

            PullRequest savedPR = saveOrUpdatePullRequest(prDto, root);

            List<ChangedFileDto> files =
                    fetchChangedFilesFromGitHub(root, prNode);

            sendToAI(savedPR, files);

            linkSprintAndProject(savedPR, root);

            return savedPR;
        }

        // =========================
        private JsonNode parseWebhook(String payload) {
            try {
                return objectMapper.readTree(payload);
            } catch (Exception e) {
                throw new RuntimeException("Invalid webhook JSON", e);
            }
        }

        // =========================
        private void validatePR(JsonNode prNode) {
            if (prNode.isMissingNode() || prNode.isNull()) {
                throw new IllegalArgumentException("pull_request missing in webhook");
            }
        }

        // =========================
        private GithubPrDto mapPullRequest(JsonNode prNode, JsonNode root) {
            return githubPrMapper.toDto(prNode, root);
        }

        // =========================
        private PullRequest saveOrUpdatePullRequest(
                GithubPrDto dto,
                JsonNode root
        ) {

            return pullRequestRepository
                    .findByGithubPrId(dto.getGithubPrId())
                    .map(existing -> update(existing, dto))
                    .orElseGet(() -> create(dto, root));
        }

        // =========================
        private List<ChangedFileDto> fetchChangedFilesFromGitHub(
                JsonNode root,
                JsonNode prNode
        ) {

            String repoFullName =
                    root.path("repository").path("full_name").asText();

            int prNumber = prNode.path("number").asInt();

            String[] parts = repoFullName.split("/");
            String owner = parts[0];
            String repo = parts[1];

            return githubApiService.getPrFiles(owner, repo, prNumber);
        }

        // =========================
        private void sendToAI(PullRequest pr, List<ChangedFileDto> files) {

            AIContextDto context = new AIContextDto();

            context.setPrId(pr.getId());
            context.setTitle(pr.getName());
            context.setFiles(files);

            // aiService.analyze(context);
        }

        // =========================
        private void linkSprintAndProject(PullRequest pr, JsonNode root) {

            String repoFullName =
                    root.path("repository").path("full_name").asText();

            Sprint sprint =
                    sprintRepository.findByRepositoryFullName(repoFullName);

            if (sprint != null) {
                pr.setSprint(sprint);
                pullRequestRepository.save(pr);
            }
        }

        // =========================
        private PullRequest update(PullRequest existing, GithubPrDto dto) {

            existing.setName(dto.getTitle());
            existing.setStatus(dto.getState());

            return pullRequestRepository.save(existing);
        }

        // =========================
        private PullRequest create(GithubPrDto dto, JsonNode root) {

            PullRequest pr = new PullRequest();

            pr.setGitHubPrId(dto.getGithubPrId());

            pr.setName(dto.getTitle());

            pr.setStatus(dto.getState() != null ? dto.getState() : "OPEN");

            pr.setAiScore(0.0);
            pr.setAiSummary("");

            String repoFullName =
                    root.path("repository").path("full_name").asText();

            pr.setSprint(null);

            return pullRequestRepository.save(pr);
        }
    }