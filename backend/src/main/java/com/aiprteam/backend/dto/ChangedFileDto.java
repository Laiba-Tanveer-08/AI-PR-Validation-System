package com.aiprteam.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangedFileDto {

        private String fileName;

        private String filePath;

        private String fileStatus;

        private Integer additions;

        private Integer deletions;

        private String patch;
    
}
