package com.aiprteam.backend.service.Impl;
import com.aiprteam.backend.dto.PrDto;
import com.aiprteam.backend.entity.*;
import com.aiprteam.backend.mapper.PrMapper;
import com.aiprteam.backend.repository.*;
import com.aiprteam.backend.service.PrService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrServiceImpl implements PrService {
    private final PullRequestRepository prRepository;
    private final SprintRepository sprintRepository;
    private final PrMapper prMapper;

    @Override
    public PrDto createPR(PrDto dto) {

        Sprint sprint = sprintRepository.findById(dto.getSprintId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sprint Not Found with id " + dto.getSprintId()));

        PullRequest pr = prMapper.toEntity(dto);
        pr.setSprint(sprint);

        PullRequest saved = prRepository.save(pr);

        return prMapper.toDto(saved);
    }

    @Override
    public PrDto getPR(Long id) {
        PullRequest pr = prRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PR not found with id: " + id));

        return prMapper.toDto(pr);
    }

    @Override
    public List<PrDto> getAllPRs(Long sprintId) {
        List<PullRequest> prs = prRepository.findBySprintId(sprintId);
        return prs.stream()
                .map(prMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PrDto updatePR(Long id, PrDto dto) {

        PullRequest existedPr = prRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PR not found with id: " + id));
        prMapper.updatePR(dto, existedPr);
        PullRequest updatedPr = prRepository.save(existedPr);
        return prMapper.toDto(updatedPr);
        }

    @Override
    public void deletePR(Long id) {
        PullRequest pr = prRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PR not found with id: " + id
                ));

        prRepository.delete(pr);
    }

}
