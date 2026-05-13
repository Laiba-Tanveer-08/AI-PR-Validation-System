package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.*;
import com.aiprteam.backend.entity.PullRequest;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.repository.RequirementRepository;
import com.aiprteam.backend.repository.SprintRepository;
import com.aiprteam.backend.service.AiContextBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AiContextBuilderServiceImpl implements AiContextBuilderService {

    private final SprintRepository sprintRepository;
    private final RequirementRepository requirementRepository;

    // =========================
    // MAIN BUILD METHOD
    // =========================
    public AIContextDto build(PullRequest pr, List<ChangedFileDto> files) {

        AIContextDto context = new AIContextDto();

        // =========================
        // 1. PR BASIC INFO (ONLY WHAT EXISTS)
        // =========================
        context.setPrId(pr.getId());
        context.setTitle(pr.getName());
        context.setDescription(pr.getAiSummary());
     

        // =========================
        // 2. FILE CHANGES
        // =========================
        context.setFiles(files);

        // =========================
        // 3. SPRINT INFO (ONLY IF EXISTS)
        // =========================
        if (pr.getSprint() != null) {
            context.setSprintId(pr.getSprint().getId());

        }

        return context;
    }





    // =========================
    // SPRINT MAPPER
    // =========================
    private SprintDto mapSprint(Sprint sprint) {

        SprintDto dto = new SprintDto();

        dto.setId(sprint.getId());
        dto.setName(sprint.getName());

        return dto;
    }

    // =========================
    // REQUIREMENTS FETCH
    // =========================
    private List<RequirementDto> fetchRequirementsBySprint(Long sprintId) {

        List<Requirement> requirements =
                requirementRepository.findBySprintId(sprintId);

        return requirements.stream()
                .map(this::mapRequirement)
                .toList();
    }

    // =========================
    // REQUIREMENT MAPPER
    // =========================
    private RequirementDto mapRequirement(Requirement req) {

        RequirementDto dto = new RequirementDto();

        dto.setId(req.getId());
        dto.setName(req.getName());
        dto.setDescription(req.getDescription());


        return dto;
    }
}
