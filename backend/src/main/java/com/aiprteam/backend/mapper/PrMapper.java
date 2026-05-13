package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.PrDto;
import com.aiprteam.backend.entity.PullRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface PrMapper {

    @Mapping(target = "sprint", ignore = true)
    PullRequest toEntity(PrDto dto);

    @Mapping(target = "sprintId", source = "sprint.id")
    PrDto toDto(PullRequest pr);

    @Mapping(target = "sprint", ignore = true)
    void updatePR(PrDto prDto, @MappingTarget PullRequest pr );
}
