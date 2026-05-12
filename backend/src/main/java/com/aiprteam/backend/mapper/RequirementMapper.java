package com.aiprteam.backend.mapper;
import com.aiprteam.backend.dto.requirement.RequirementDTO;
import com.aiprteam.backend.entity.Requirement;
import org.mapstruct.Mapper;
@Mapper (componentModel = "spring")
public interface RequirementMapper {
    //DTO to Entity
    Requirement toEntity(RequirementDTO dto);
    //Entity to DTO
    RequirementDTO toDto(Requirement requirement);
}