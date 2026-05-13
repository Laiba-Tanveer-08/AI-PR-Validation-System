package com.aiprteam.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
