package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.service.GithubService;

public class GithubServiceImpl implements GithubService {
    @Override
    public void handlePullRequestWebhook(String payload) {

        try {

            // 1. Parse webhook payload
            JSONObject json = new JSONObject(payload);

            String action = json.getString("action");

            JSONObject prObject = json.getJSONObject("pull_request");

            Integer prNumber = prObject.getInt("number");

            String repoName = json.getJSONObject("repository").getString("name");

            String repoOwner = json.getJSONObject("repository")
                    .getJSONObject("owner")
                    .getString("login");

            // 2. Filter events
            if (!action.equals("opened")
                    && !action.equals("synchronize")
                    && !action.equals("reopened")) {
                return;
            }

            // 3. Fetch PR details
            PullRequestDTO pullRequest =
                    fetchPullRequest(repoOwner, repoName, prNumber);

            prService.saveOrUpdatePullRequest(pullRequest);

            // 4. Fetch changed files
            List<ChangedFileDTO> changedFiles =
                    fetchChangedFiles(repoOwner, repoName, prNumber);

            // 5. Build context
            PRContextDTO context =
                    prContextService.buildContext(pullRequest, changedFiles);

            // 6. AI result (NOW SIMPLE STRING OBJECT)
            AIResponseDTO aiResponse =
                    aiValidationService.validate(context);

            // 7. Post GitHub comments
            gitHubCommentService.postReviewComments(
                    repoOwner,
                    repoName,
                    prNumber,
                    aiResponse.getComments(),
                    aiResponse.getSummary()
            );

            // 8. Update Pull Request entity with AI results
            prService.updateAIResult(
                    prNumber,
                    aiResponse.getScore(),
                    aiResponse.getSummary(),
                    aiResponse.getComments()
            );

        } catch (Exception e) {
            throw new RuntimeException("Error handling GitHub webhook", e);
        }
    }

    @Override
    public PullRequestDTO fetchPullRequest(String repoOwner, String repoName, Integer prNumber) {
        return null;
    }

    @Override
    public List<ChangedFileDTO> fetchChangedFiles(String repoOwner, String repoName, Integer prNumber) {
        return null;
    }

    @Override
    public RepositoryDTO fetchRepositoryDetails(String repoOwner, String repoName) {
        return null;
    }

    @Override
    public boolean validateConnection(String accessToken) {
        return false;
    }
}
