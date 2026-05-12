package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.project.ProjectDto;
import com.aiprteam.backend.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")

public interface ProjectMapper {

    @Mapping(target="sprint", ignore = true)
    @Mapping(target="user", ignore = true)
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

    @Mapping(
            target = "pullRequestIds",
            expression = "java(project.getPullRequests() != null ? " +
                    "project.getPullRequests().stream().map(PullRequest::getId).toList() : null)"
    )

    ProjectDto toDto(Project project);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "sprints", ignore = true)
    @Mapping(target = "gitHubConnections", ignore = true)
    @Mapping(target = "requirements", ignore = true)
    @Mapping(target = "pullRequests", ignore = true)
    void updateProjectFromDto(ProjectDto dto, @MappingTarget Project project);
}
