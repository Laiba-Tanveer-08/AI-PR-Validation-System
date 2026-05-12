package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.sprint.SprintDto;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.mapper.ProjectMapper;
import com.aiprteam.backend.mapper.SprintMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.ProjectService;
import com.aiprteam.backend.service.SprintService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class SprintServiceImpl implements SprintService {
    private SprintRepository sprintRepository;
    private ProjectRepository projectRepository;
    SprintMapper sprintMapper;
    private Sprint  sprint;

    @Override
    public List<SprintDto> getAllSprint(Long projectId) {
        List<Sprint> sprints = sprintRepository.findByProjectId(projectId);
        return sprints.stream().map(sprintMapper::toDto).toList();
    }

    @Override
    public SprintDto getSprint(Long id, Long projectId) {
        sprint=sprintRepository.findByIdAndProjectId(id, projectId)  .orElseThrow(() -> new RuntimeException("Sprint not found with id: " + id));
        return (sprintMapper.toDto(sprint));
    }

    @Override
    public SprintDto createSprint(SprintDto dto) {
        Project project = projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new RuntimeException("Project not found with id: " + dto.getProjectId()));
        Sprint sprint = sprintMapper.toEntity(dto);
        sprint.setProject(project);
        sprintRepository.save(sprint);
        return (sprintMapper.toDto(sprint));
    }

    @Override
    public SprintDto updateSprint(Long id, SprintDto dto) {
        sprint=sprintRepository.findById(id).orElseThrow(() -> new RuntimeException("Sprint not found with id: " + id));
        sprintMapper.updateEntityFromDto(dto, sprint);
        sprintRepository.save(sprint);
        return (sprintMapper.toDto(sprint));
    }

    @Override
    public void deleteSprint(Long id) {
        sprint=sprintRepository.findById(id).orElseThrow(() -> new RuntimeException("Sprint not found with id: " + id));
        sprintRepository.delete(sprint);
    }
}
