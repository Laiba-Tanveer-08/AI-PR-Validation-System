package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.requirement.RequirementDTO;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.mapper.RequirementMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.RequirementRepository;

import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.RequirementService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequirementServiceImpl implements RequirementService {
    private final RequirementRepository requirementRepository;
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final RequirementMapper requirementMapper;

    public RequirementServiceImpl(RequirementRepository requirementRepository,
                                  SprintRepository sprintRepository,
                                  ProjectRepository projectRepository,
                                  RequirementMapper requirementMapper) {
        this.requirementRepository = requirementRepository;
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
        this.requirementMapper = requirementMapper;
    }

    // ✅ CREATE
    @Override
    public RequirementDTO createRequirement(RequirementDTO dto) {

        Requirement requirement = requirementMapper.toEntity(dto);

        // 🔗 Set Sprint
        if (dto.getSprintId() != null) {
            requirement.setSprint(sprintRepository.findById(dto.getSprintId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Sprint not found"
                    )));
        }

        // 🔗 Set Project
        if (dto.getProjectId() != null) {
            requirement.setProject(projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Project not found"
                    )));
        }

        Requirement saved = requirementRepository.save(requirement);

        return requirementMapper.toDto(saved);
    }

    // ✅ GET BY ID
    @Override
    public RequirementDTO getRequirementById(Long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found with id: " + id
                ));

        return requirementMapper.toDto(requirement);
    }

    // ✅ GET ALL
    @Override
    public List<RequirementDTO> getAllRequirements() {
        return requirementRepository.findAll()
                .stream()
                .map(requirementMapper::toDto)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE
    @Override
    public RequirementDTO updateRequirement(Long id, RequirementDTO dto) {

        Requirement existing = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found"
                ));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());

        // 🔗 Update Sprint
        if (dto.getSprintId() != null) {
            existing.setSprint(sprintRepository.findById(dto.getSprintId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Sprint not found"
                    )));
        }

        // 🔗 Update Project
        if (dto.getProjectId() != null) {
            existing.setProject(projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Project not found"
                    )));
        }

        Requirement updated = requirementRepository.save(existing);

        return requirementMapper.toDto(updated);
    }

    // ✅ DELETE
    @Override
    public void deleteRequirement(Long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found"
                ));

        requirementRepository.delete(requirement);
    }

}



