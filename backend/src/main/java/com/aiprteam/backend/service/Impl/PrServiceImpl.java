package com.aiprteam.backend.service.Impl;
import com.aiprteam.backend.dto.PrDto;
import com.aiprteam.backend.entity.*;
import com.aiprteam.backend.mapper.PrMapper;
import com.aiprteam.backend.repository.*;
import com.aiprteam.backend.service.PrService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PrServiceImpl implements PrService {
    private final PullRequestRepository prRepository;
    private final RequirementRepository requirementRepository;
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final PrMapper prMapper;

    // 🔌 Constructor Injection
    public PrServiceImpl(PullRequestRepository prRepository,
                         RequirementRepository requirementRepository,
                         SprintRepository sprintRepository,
                         ProjectRepository projectRepository,
                         PrMapper prMapper) {
        this.prRepository = prRepository;
        this.requirementRepository = requirementRepository;
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
        this.prMapper = prMapper;
    }

    // ✅ CREATE PR
    @Override
    public PrDto createPR(PrDto dto) {

        // Convert DTO → Entity
        PullRequest pr = prMapper.toEntity(dto);

        // Set Requirement
        if (dto.getRequirementId() != null) {
            pr.setRqr(requirementRepository.findById(dto.getRequirementId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Requirement not found with id: " + dto.getRequirementId()
                    )));
        }

        // Set Sprint
        if (dto.getSprintId() != null) {
            pr.setSprint(sprintRepository.findById(dto.getSprintId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Sprint not found with id: " + dto.getSprintId()
                    )));
        }

        //  Set Project
        if (dto.getProjectId() != null) {
            pr.setProject(projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Project not found with id: " + dto.getProjectId()
                    )));
        }

        // Save to DB
        PullRequest saved = prRepository.save(pr);

        // Convert back → DTO
        return prMapper.toDto(saved);
    }

    // ✅ GET PR BY ID
    @Override
    public PrDto getPRById(Long id) {
        PullRequest pr = prRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "PR not found with id: " + id
                ));

        return prMapper.toDto(pr);
    }

    // ✅ GET ALL PRs
    @Override
    public List<PrDto> getAllPRs() {
        return prRepository.findAll()
                .stream()
                .map(prMapper::toDto)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE PR
    @Override
    public PrDto updatePR(Long id, PrDto dto) {

        PullRequest existing = prRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "PR not found with id: " + id
                ));

        // Update fields
        existing.setName(dto.getName());
        existing.setGitHubPrId(dto.getGitHubPrId());
        existing.setStatus(dto.getStatus());

        //  Update Requirement
        if (dto.getRequirementId() != null) {
            existing.setRqr(requirementRepository.findById(dto.getRequirementId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Requirement not found"
                    )));
        }

        // Update Sprint
        if (dto.getSprintId() != null) {
            existing.setSprint(sprintRepository.findById(dto.getSprintId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Sprint not found"
                    )));
        }

        //  Update Project
        if (dto.getProjectId() != null) {
            existing.setProject(projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Project not found"
                    )));
        }

        PullRequest updated = prRepository.save(existing);

        return prMapper.toDto(updated);
    }

    // ✅ DELETE PR
    @Override
    public void deletePR(Long id) {
        PullRequest pr = prRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "PR not found with id: " + id
                ));

        prRepository.delete(pr);
    }

}
