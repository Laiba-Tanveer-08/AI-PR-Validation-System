package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubWebhookDto {
        private Long prNumber;
        private String action;
        private String repoName;
        private String repoOwner;
        private String pullRequestTitle;
        private String sender;
    }

