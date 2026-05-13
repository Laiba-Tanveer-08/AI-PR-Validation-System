package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.UserDto;
import com.aiprteam.backend.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto dto);
    ProjectDto getProject(Long Id);
    ProjectDto updateProject(ProjectDto dto);
    void deleteProject(Long Id);
    List<ProjectDto> getAllProjects();

}
