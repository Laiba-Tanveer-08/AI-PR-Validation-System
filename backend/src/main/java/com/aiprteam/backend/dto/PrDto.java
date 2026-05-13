package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrDto {
        private Long id;
        private String name;
        private String aiSummary;
        private Double aiScore;
        private String gitHubPrId;
        private String status;
        private Long sprintId;
    }

