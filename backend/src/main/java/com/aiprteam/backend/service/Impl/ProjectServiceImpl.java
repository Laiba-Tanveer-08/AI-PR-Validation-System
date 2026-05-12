package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.auth.UserDto;
import com.aiprteam.backend.dto.project.ProjectDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.mapper.AuthMapper;
import com.aiprteam.backend.mapper.ProjectMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.service.AuthService;
import com.aiprteam.backend.service.ProjectService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    ProjectMapper projectMapper;
    AuthMapper authMapper;
    Project project;
    AuthService authService = new AuthServiceImpl();

    public ProjectDto createProject(ProjectDto dto){

        project =  projectRepository.save(projectMapper.toEntity(dto));
        project.setUser(authMapper.toEntity(authService.getCurrentUser()));

        return projectMapper.toDto(project);
    }

    public ProjectDto getProject(Long Id){

            UserDto user  = authService.getCurrentUser();
            Project project= projectRepository.findByIdAndUserId(Id, user.getId())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + Id));

           return  projectMapper.toDto(project);
        }



    @Override
    public ProjectDto updateProject(ProjectDto dto) {
        UserDto currentUser = authService.getCurrentUser();

        Project existedProject = projectRepository
                .findByIdAndUserId(dto.getId(), currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Project not found"));
        projectMapper.updateProjectFromDto(dto, existedProject);
       Project updatedProject = projectRepository.save(existedProject);

       return projectMapper.toDto(updatedProject);
    }

    @Override
    public void deleteProject(Long Id) {

        UserDto currentUser = authService.getCurrentUser();

        project = projectRepository
                .findByIdAndUserId(Id, currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Project not found"));
         projectRepository.delete(project);
    }

    @Override
    public List<ProjectDto> getAllProjects(UserDto dto) {

        List<Project> projects = projectRepository.findByUserId(dto.getId());
        return projects.stream()
                .map(projectMapper::toDto)
                .toList();
    }
}
