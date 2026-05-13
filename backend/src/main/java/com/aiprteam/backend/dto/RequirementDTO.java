package com.aiprteam.backend.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequirementDTO {
    private Long id;
    private String name;
    private String description;

    private Long sprintId;
    private Long projectId;
}
