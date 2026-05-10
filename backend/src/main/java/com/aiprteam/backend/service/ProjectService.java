package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.project.ProjectDto;

public interface ProjectService {
    ProjectDto addProject(ProjectDto projectDTO);
    ProjectDto showProject(Long Id);

}
