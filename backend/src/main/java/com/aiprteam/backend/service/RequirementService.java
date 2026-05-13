package com.aiprteam.backend.service;
import com.aiprteam.backend.dto.RequirementDTO;
import java.util.List;

public interface RequirementService {
    RequirementDTO createRequirement(RequirementDTO dto);


    // ✅ GET BY ID
    RequirementDTO getRequirementById(Long id);

    List<RequirementDTO>getAllRequirements();
    RequirementDTO updateRequirement(Long id ,RequirementDTO dto);
    void deleteRequirement(Long id);

}
