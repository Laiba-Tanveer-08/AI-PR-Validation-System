package com.aiprteam.backend.mapper;
import com.aiprteam.backend.dto.pr.PrDTO;
import com.aiprteam.backend.entity.PullRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface PrMapper {
    // 🔁 DTO → Entity (ignore relationships, handled in service)
    @Mapping(target = "rqr", ignore = true)
    @Mapping(target = "sprint", ignore = true)
    @Mapping(target = "project", ignore = true)
    PullRequest toEntity(PrDTO dto);

    // 🔁 Entity → DTO
    @Mapping(target = "requirementId", source = "rqr.id")
    @Mapping(target = "sprintId", source = "sprint.id")
    @Mapping(target = "projectId", source = "project.id")
    PrDTO toDto(PullRequest pr);
}
