package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.ChangedFileDto;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

@Component
public class ChangedFileMapper {

    public ChangedFileDto toDto(JsonNode fileNode) {

            ChangedFileDto dto = new ChangedFileDto();

            dto.setFileName(fileNode.path("filename").asString());

            dto.setFilePath(fileNode.path("filename").asString());
            // GitHub uses same value, but you can later split path if needed

            dto.setFileStatus(fileNode.path("status").asString());

            dto.setAdditions(fileNode.path("additions").asInt(0));

            dto.setDeletions(fileNode.path("deletions").asInt(0));

            dto.setPatch(fileNode.path("patch").asString(""));

            return dto;
        }
    }

