package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.RegisterRequestDto;
import com.aiprteam.backend.dto.UserDto;
import com.aiprteam.backend.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "password", expression = "java(encodePassword(dto.getPassword(), passwordEncoder))") // handled in service (encoding)
    Users toEntity(RegisterRequestDto dto);
    Users toEntity(UserDto dto);
    // Entity → DTO
    @Mapping(
            target = "projectIds",
            expression = "java(project.getProjects() != null ? " +
                    "user.getProjects().stream().map(Project::getId).toList() : null)"
    )
    UserDto toDto(Users user);

}
