package com.aiprteam.backend.service;
import com.aiprteam.backend.dto.pr.PrDTO;
import java.util.List;
public interface PrService {
    // ✅ Create a new Pull Request
    PrDTO createPR(PrDTO dto);

    // ✅ Get PR by ID
    PrDTO getPRById(Long id);

    // ✅ Get all PRs
    List<PrDTO> getAllPRs();

    // ✅ Update PR
    PrDTO updatePR(Long id, PrDTO dto);

    // ✅ Delete PR
    void deletePR(Long id);

}
