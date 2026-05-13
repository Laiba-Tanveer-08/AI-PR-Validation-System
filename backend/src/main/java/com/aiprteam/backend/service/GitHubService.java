package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.dto.GithubWebhookDto;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface GitHubService {

    boolean validateWebhookSignature(String payload, String signature, String secret);

    JsonNode parseWebhook(String payload);

    GithubWebhookDto extractRepoMetadata(JsonNode root);

    String extractAction(JsonNode root);

    int extractPrNumber(JsonNode root);

    List<ChangedFileDto> fetchPrFiles(String owner, String repo, int prNumber);
}