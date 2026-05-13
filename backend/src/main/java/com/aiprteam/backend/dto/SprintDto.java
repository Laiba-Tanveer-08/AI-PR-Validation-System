package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SprintDto {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Long projectId;
    private List<Long> requirementIds;
}
