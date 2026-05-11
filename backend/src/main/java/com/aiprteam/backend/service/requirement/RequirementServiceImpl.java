package com.aiprteam.backend.service.requirement;
import com.aiprteam.backend.dto.requirement.RequirementDTO;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.repository.RequirementRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RequirementServiceImpl implements RequirementService {
    private final RequirementRepository requirementRepository;

    public RequirementServiceImpl(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }
    @Override
    public RequirementDTO createRequirement(RequirementDTO dto) {
        Requirement requirement = mapToEntity(dto);
        Requirement savedRequirement = requirementRepository.save(requirement);
        return mapToDTO(savedRequirement);
    }


    @Override
    public RequirementDTO getRequirementById(long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found with id: " + id
                ));

        return mapToDTO(requirement);
    }


    @Override
    public List<RequirementDTO> getAllRequirements() {
        List<Requirement> list = requirementRepository.findAll();

        return list.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public RequirementDTO updateRequirement(long id, RequirementDTO dto) {
        Requirement existing = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found with id: " + id
                ));


        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());

        Requirement updated = requirementRepository.save(existing);

        return mapToDTO(updated);
    }


    @Override
    public RequirementDTO deleteRequirement(long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requirement not found with id: " + id
                ));

        requirementRepository.delete(requirement);
        return null;
    }

    // 🔁 DTO → ENTITY
    private Requirement mapToEntity(RequirementDTO dto) {
        Requirement r = new Requirement();
        r.setName(dto.getName());              // ✅ matches entity
        r.setDescription(dto.getDescription());
        return r;
    }

    // 🔁 ENTITY → DTO
    private RequirementDTO mapToDTO(Requirement r) {
        RequirementDTO dto = new RequirementDTO();
        dto.setId(r.getId());
        dto.setName(r.getName());              // ✅ matches entity
        dto.setDescription(r.getDescription());
        return dto;
    }
}





