package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubWebhookDto {
        private Long githubRepoId;

        private String repoName;

        private String repoOwner;

        private String defaultBranch;

        private Boolean isPrivate;

        private String repoUrl;
    }

