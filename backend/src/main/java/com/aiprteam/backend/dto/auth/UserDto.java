package com.aiprteam.backend.dto.auth;
import com.aiprteam.backend.dto.project.ProjectDto;
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
