package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.UserDto;
import com.aiprteam.backend.dto.ProjectDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.exception.ResourceNotFoundException;
import com.aiprteam.backend.mapper.AuthMapper;
import com.aiprteam.backend.mapper.ProjectMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.service.AuthService;
import com.aiprteam.backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
   private final ProjectRepository projectRepository;
   private final ProjectMapper projectMapper;
   private final AuthMapper authMapper;
   private final AuthService authService;
    public ProjectDto createProject(ProjectDto dto){
        Project project =projectMapper.toEntity(dto);
        project.setUser(authMapper.toEntity(authService.getCurrentUser()));
        project =  projectRepository.save(project);

        return projectMapper.toDto(project);
    }

    public ProjectDto getProject(Long Id){

            UserDto user  = authService.getCurrentUser();
            Project project= projectRepository.findByIdAndUserId(Id, user.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + Id));

           return  projectMapper.toDto(project);
        }

    @Override
    public ProjectDto updateProject(ProjectDto dto) {
        UserDto currentUser = authService.getCurrentUser();

        Project existedProject = projectRepository
                .findByIdAndUserId(dto.getId(), currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectMapper.updateProjectFromDto(dto, existedProject);
        Project updatedProject = projectRepository.save(existedProject);

        return projectMapper.toDto(updatedProject);
    }

    @Override
    public void deleteProject(Long Id) {
        Project project;
        UserDto currentUser = authService.getCurrentUser();

        project = projectRepository
                .findByIdAndUserId(Id, currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
         projectRepository.delete(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        UserDto dto = authService.getCurrentUser();
        List<Project> projects = projectRepository.findByUserId(dto.getId());
        return projects.stream()
                .map(projectMapper::toDto)
                .toList();
    }
}
