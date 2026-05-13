package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubConnectionDto {
    private String repoName;
    private String repoOwner;
    private String repoUrl;
    private Long projectId;
    private Long userId;
}
