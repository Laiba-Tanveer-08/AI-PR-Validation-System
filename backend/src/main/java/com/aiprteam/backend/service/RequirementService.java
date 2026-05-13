package com.aiprteam.backend.service;
import com.aiprteam.backend.dto.RequirementDto;
import java.util.List;

public interface RequirementService {
    RequirementDto createRequirement(RequirementDto dto);


    // ✅ GET BY ID
    RequirementDto getRequirementById(Long id);

    List<RequirementDto>getAllRequirements();
    RequirementDto updateRequirement(Long id , RequirementDto dto);
    void deleteRequirement(Long id);

}
