package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.RequirementDto;
import com.aiprteam.backend.dto.SprintDto;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.entity.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RequirementMapper {
    @Mapping(target = "sprint", ignore = true)
    Requirement toEntity(RequirementDto dto);

    @Mapping(target = "sprintId", source = "sprint.id")
    RequirementDto toDto(Requirement requirement);
    void updateEntityFromDto(RequirementDto dto, @MappingTarget Requirement requirement);
}