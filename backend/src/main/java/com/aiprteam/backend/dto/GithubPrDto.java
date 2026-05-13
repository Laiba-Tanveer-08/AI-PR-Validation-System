package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubPrDto {

    private Long prNumber;
    private String prTitle;
    private List<String> changedFiles;
    private String author;
    private String branch;
    private String diff;
    private String status;
    private String repoName;
    private String repoOwner;
}

