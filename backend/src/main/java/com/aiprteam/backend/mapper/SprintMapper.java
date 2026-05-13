package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.SprintDto;
import com.aiprteam.backend.entity.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface SprintMapper {
    @Mapping(target="project" , ignore = true)
    @Mapping(target="requirements" , ignore = true)
    SprintDto toDto(Sprint sprint);
    Sprint toEntity(SprintDto dto);
    void updateEntityFromDto(SprintDto dto, @MappingTarget Sprint sprint);
}
