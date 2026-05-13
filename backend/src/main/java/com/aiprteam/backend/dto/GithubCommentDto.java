package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubCommentDto {
    private String comment;
    private Long lineNo;
    private String filePath;
    private Long prNumber;
}
