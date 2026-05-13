package com.aiprteam.backend.dto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Long> projectIds;
}
