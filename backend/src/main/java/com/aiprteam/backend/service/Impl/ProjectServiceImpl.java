package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.auth.UserResponseDto;
import com.aiprteam.backend.dto.project.ProjectDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.mapper.ProjectMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.UsersRepository;
import com.aiprteam.backend.service.ProjectService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UsersRepository userRepository;
    ProjectMapper projectMapper;

    public ProjectDto addProject(ProjectDto dto){
        Project project;
        project =  projectRepository.save(projectMapper.toEntity(dto));

        return projectMapper.toDto(project);
    }
public ProjectDto showProject(Long Id){
    AuthServiceImpl authService = new AuthServiceImpl();
    UserResponseDto user  = authService.getCurrentUser();
    Project project= projectRepository.findByIdAndUserId(Id, user.getId())
            .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + Id));
   return  projectMapper.toDto(project);
}}
