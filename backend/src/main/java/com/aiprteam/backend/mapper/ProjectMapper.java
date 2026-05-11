package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.project.ProjectDto;
import com.aiprteam.backend.entity.Project;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface ProjectMapper {

    Project toEntity(ProjectDto dto);

    ProjectDto toDto(Project project);
}
