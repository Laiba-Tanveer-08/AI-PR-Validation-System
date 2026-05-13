package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.SprintDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.exception.ResourceNotFoundException;
import com.aiprteam.backend.mapper.RequirementMapper;
import com.aiprteam.backend.mapper.SprintMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.AuthService;
import com.aiprteam.backend.service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SprintServiceImpl implements SprintService {
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final SprintMapper sprintMapper;
    private final RequirementMapper requirementMapper;
    private final AuthService authService;

    @Override
    public List<SprintDto> getAllSprint(Long projectId) {
        Long userId = authService.getCurrentUser().getId();
        List<Sprint> sprints = sprintRepository.findByProjectIdAndProjectUserId(projectId, userId);
        return sprints.stream().map(sprintMapper::toDto).toList();
    }


    @Override
    public SprintDto getSprint(Long id, Long projectId) {
        Long userId = authService.getCurrentUser().getId();
        Sprint sprint = sprintRepository.findByIdAndProjectIdAndProjectUserId(id, projectId, userId).orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));
        return sprintMapper.toDto(sprint);
    }

    @Override
    public SprintDto createSprint(SprintDto dto) {
        Long userId = authService.getCurrentUser().getId();
        Project project = projectRepository.findByIdAndUserId(dto.getProjectId(), userId).orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + dto.getProjectId()));
        Sprint sprint = sprintMapper.toEntity(dto);
        sprint.setProject(project);
        sprintRepository.save(sprint);
        return (sprintMapper.toDto(sprint));
    }

    @Override
    public SprintDto updateSprint(Long id, SprintDto dto) {
        Long userId = authService.getCurrentUser().getId();
        Sprint sprint = sprintRepository.findByIdAndProjectId(id, userId).orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + id));
        sprintMapper.updateEntityFromDto(dto, sprint);
        sprintRepository.save(sprint);
        return (sprintMapper.toDto(sprint));
    }

    @Override
    public void deleteSprint(Long id) {
        Long userId = authService.getCurrentUser().getId();
        Sprint sprint = sprintRepository.findByIdAndProjectUserId(id, userId).orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + id));
        sprintRepository.delete(sprint);
    }
}
