package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.PrDto;
import java.util.List;
public interface PrService {
    // ✅ Create a new Pull Request
    PrDto createPR(PrDto dto);

    // ✅ Get PR by ID
    PrDto getPRById(Long id);

    // ✅ Get all PRs
    List<PrDto> getAllPRs();

    // ✅ Update PR
    PrDto updatePR(Long id, PrDto dto);

    // ✅ Delete PR
    void deletePR(Long id);

}
