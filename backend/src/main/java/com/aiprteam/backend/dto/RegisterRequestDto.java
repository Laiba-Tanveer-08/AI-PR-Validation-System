package com.aiprteam.backend.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String name;
    private String password;
    private String emailAddress;

}
