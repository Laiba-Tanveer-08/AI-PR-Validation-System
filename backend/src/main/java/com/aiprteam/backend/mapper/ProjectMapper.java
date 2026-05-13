package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.ProjectDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.entity.GitHubConnection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
        imports = {Sprint.class, GitHubConnection.class}
)
public interface ProjectMapper {

    @Mapping(target = "sprints", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "gitHubConnections", ignore = true)
    Project toEntity(ProjectDto dto);

    @Mapping(source = "user.id", target = "userId")

    @Mapping(
            target = "sprintIds",
            expression = "java(project.getSprints() != null ? " +
                    "project.getSprints().stream().map(Sprint::getId).toList() : null)"
    )

    @Mapping(
            target = "gitHubConnectionIds",
            expression = "java(project.getGitHubConnections() != null ? " +
                    "project.getGitHubConnections().stream().map(GitHubConnection::getId).toList() : null)"
    )

    ProjectDto toDto(Project project);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "sprints", ignore = true)
    @Mapping(target = "gitHubConnections", ignore = true)
    void updateProjectFromDto(ProjectDto dto, @MappingTarget Project project);
}