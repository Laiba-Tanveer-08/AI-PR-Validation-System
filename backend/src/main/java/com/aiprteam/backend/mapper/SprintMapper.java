package com.aiprteam.backend.mapper;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.dto.SprintDto;
import com.aiprteam.backend.entity.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface SprintMapper {
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "requirements", ignore = true)
    Sprint toEntity(SprintDto dto);

    @Mapping(target = "projectId", source = "project.id")
    @Mapping(target = "requirementIds",
            expression = "java(sprint.getRequirements()!=null?" +
            "sprint.getRequirements().stream().map(Requirement::getId).toList() : null)")
    SprintDto toDto(Sprint sprint);
    @Mapping(target="project", ignore=true)
    @Mapping(target = "requirements", ignore = true)
    void updateEntityFromDto(SprintDto dto, @MappingTarget Sprint sprint);
}
