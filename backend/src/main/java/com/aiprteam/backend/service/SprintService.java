package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.SprintDto;

import java.util.List;

public interface SprintService {
    public List<SprintDto> getAllSprint(Long projectId);

    public SprintDto getSprint(Long id, Long projectId);

    public SprintDto createSprint(SprintDto dto);

    public SprintDto updateSprint(Long id, SprintDto dto);

    public void deleteSprint(Long id);

}
