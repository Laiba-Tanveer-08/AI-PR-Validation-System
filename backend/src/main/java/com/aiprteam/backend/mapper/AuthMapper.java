package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.auth.RegisterRequestDto;
import com.aiprteam.backend.dto.auth.UserResponseDto;
import com.aiprteam.backend.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "password", expression = "java(encodePassword(dto.getPassword(), passwordEncoder))") // handled in service (encoding)
    Users toEntity(RegisterRequestDto dto);

    // Entity → DTO
    UserResponseDto toDto(Users user);

}
