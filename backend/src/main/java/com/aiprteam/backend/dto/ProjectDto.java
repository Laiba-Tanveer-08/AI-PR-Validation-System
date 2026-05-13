package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int noOfSprints;
    private List<Long> sprintIds;
    private Long userId;
    private List<Long> gitHubConncetionIds;
    private List<Long> pullRequestIds;
}
