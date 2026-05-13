package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.RequirementDto;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.exception.ResourceNotFoundException;
import com.aiprteam.backend.mapper.RequirementMapper;
import com.aiprteam.backend.repository.RequirementRepository;
import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.AuthService;
import com.aiprteam.backend.service.RequirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RequirementServiceImpl implements RequirementService {
    private final RequirementRepository requirementRepository;
    private final SprintRepository sprintRepository;
    private final RequirementMapper requirementMapper;
    private final AuthService authService;

    @Override
    public RequirementDto createRequirement(RequirementDto dto) {
        Long userId = authService.getCurrentUser().getId();
        Sprint sprint = sprintRepository.findByIdAndProjectUserId(dto.getSprintId(), userId).orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + dto.getSprintId()));
        Requirement requirement = requirementMapper.toEntity(dto);
        requirement.setSprint(sprint);
        requirementRepository.save(requirement);
        return requirementMapper.toDto(requirement);
    }

    @Override
    public RequirementDto getRequirementById(Long id) {
        Long userId = authService.getCurrentUser().getId();
        Requirement requirement = requirementRepository.findByIdAndSprintProjectUserId(id, userId).orElseThrow(() -> new ResourceNotFoundException("Requirement not found with id: " + id));
        return requirementMapper.toDto(requirement);
    }

    @Override
    public List<RequirementDto> getAllRequirements(Long sprintId) {
        Long userId = authService.getCurrentUser().getId();
        List<Requirement> requirements = requirementRepository.findBySprintIdAndSprintProjectUserId(sprintId, userId);
        return requirements.stream().map(requirementMapper::toDto).toList();
    }

    @Override
    public RequirementDto updateRequirement(Long id, RequirementDto dto) {
        Long userId = authService.getCurrentUser().getId();
        Sprint sprint = sprintRepository.findByIdAndProjectUserId(dto.getSprintId(), userId).orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + dto.getSprintId()));
        Requirement requirement = requirementRepository.findByIdAndSprintProjectUserId(id, userId).orElseThrow(() -> new ResourceNotFoundException("Requirement not found with id: " + id));
        requirement.setSprint(sprint);
        requirementMapper.updateEntityFromDto(dto, requirement);
        requirementRepository.save(requirement);
        return requirementMapper.toDto(requirement);
    }

    @Override
    public void deleteRequirement(Long id) {
        Long userId = authService.getCurrentUser().getId();
        Requirement requirement = requirementRepository.findByIdAndSprintProjectUserId(id, userId).orElseThrow(() -> new ResourceNotFoundException("Requirement not found"));
        requirementRepository.delete(requirement);

    }
}



