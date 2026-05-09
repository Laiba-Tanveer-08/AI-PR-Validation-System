package com.aiprteam.backend.service.requirement;
import com.aiprteam.backend.dto.requirement.RequirementDTO;
import java.util.List;

public interface RequirementService {
    RequirementDTO createRequirement(RequirementDTO dto);


    // ✅ GET BY ID
    RequirementDTO getRequirementById(long id);

    List<RequirementDTO>getAllRequirements();
    RequirementDTO updateRequirement(long id ,RequirementDTO dto);
    RequirementDTO deleteRequirement(long id);

}
