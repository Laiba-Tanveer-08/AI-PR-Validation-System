package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.RequirementDto;
import com.aiprteam.backend.entity.Requirement;

import java.util.List;

public interface RequirementService {
    RequirementDto createRequirement(RequirementDto dto);
    RequirementDto getRequirementById(Long id);
    List<RequirementDto> getAllRequirements(Long sprintId);
    RequirementDto updateRequirement(Long id, RequirementDto dto);
    void deleteRequirement(Long id);

}
