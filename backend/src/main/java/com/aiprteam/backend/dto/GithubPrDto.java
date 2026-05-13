package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubPrDto {
        private Long githubPrId;

                private String title;
                private String description;

                private String sourceBranch;
                private String targetBranch;

                private String author;
                private Long authorId;

                private String state;
                private boolean merged;
                private boolean draft;

                private String createdAt;
                private String updatedAt;

                private String htmlUrl;

                private String repoName;
                private String repoFullName;
        }

