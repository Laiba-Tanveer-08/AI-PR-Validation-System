package com.aiprteam.backend.service;

public interface GithubService {
    void handlePullRequestWebhook(String payload);
    PullRequestDTO fetchPullRequest(String repoOwner, String repoName,
                                        Integer prNumber);

    List<ChangedFileDTO> fetchChangedFiles(String repoOwner,
                                               String repoName,
                                               Integer prNumber);

    RepositoryDTO fetchRepositoryDetails(String repoOwner, String repoName);
    boolean validateConnection(String accessToken);

}
