package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequirementDto {
    private Long id;
    private String name;
    private String description;
    private Long sprintId;
//  private Long projectId;
}
