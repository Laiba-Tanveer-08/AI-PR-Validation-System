package com.aiprteam.backend.mapper;
import com.aiprteam.backend.dto.PrDto;
import com.aiprteam.backend.entity.PullRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface PrMapper {
    // 🔁 DTO → Entity (ignore relationships, handled in service)
    @Mapping(target = "rqr", ignore = true)
    @Mapping(target = "sprint", ignore = true)
    @Mapping(target = "project", ignore = true)
    PullRequest toEntity(PrDto dto);

    // 🔁 Entity → DTO
    @Mapping(target = "requirementId", source = "rqr.id")
    @Mapping(target = "sprintId", source = "sprint.id")
    @Mapping(target = "projectId", source = "project.id")
    PrDto toDto(PullRequest pr);
}
