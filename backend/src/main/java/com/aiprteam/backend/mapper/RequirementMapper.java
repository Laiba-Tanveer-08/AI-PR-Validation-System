package com.aiprteam.backend.mapper;
import com.aiprteam.backend.dto.requirement.RequirementDTO;
import com.aiprteam.backend.entity.Requirement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface RequirementMapper {
    @Mapping(target = "sprint", ignore = true)
    @Mapping(target = "project", ignore = true)
    Requirement toEntity(RequirementDTO dto);

    // Entity → DTO
    @Mapping(target = "sprintId", source = "sprint.id")
    @Mapping(target = "projectId", source = "project.id")
    RequirementDTO toDto(Requirement requirement);

}