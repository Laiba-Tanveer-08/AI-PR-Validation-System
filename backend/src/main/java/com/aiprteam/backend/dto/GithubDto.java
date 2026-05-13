package com.aiprteam.backend.dto;

import java.time.LocalDateTime;

public class GithubDto {


        private Long id;

        private String repoUrl;

        private String webHookUrl;

        private String repoName;

        private String repoOwner;

        private LocalDateTime connectedAt;

        private LocalDateTime lastSyncedAt;

        private String status;

        // Instead of full object
        private Long projectId;

        // Instead of full Users object
        private Long userId;
    }

