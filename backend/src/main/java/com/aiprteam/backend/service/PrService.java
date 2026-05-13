package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.PrDto;

import java.util.List;

public interface PrService {

    PrDto createPR(PrDto dto);
    PrDto getPR(Long id);
    List<PrDto> getAllPRs(Long sprintId);
    PrDto updatePR(Long id, PrDto dto);
    void deletePR(Long id);

}
