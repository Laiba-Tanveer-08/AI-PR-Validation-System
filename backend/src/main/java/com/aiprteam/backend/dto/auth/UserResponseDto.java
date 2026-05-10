package com.aiprteam.backend.dto.auth;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
}
