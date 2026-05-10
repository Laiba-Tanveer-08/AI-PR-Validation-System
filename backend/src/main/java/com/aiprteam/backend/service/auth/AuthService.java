package com.aiprteam.backend.service.auth;

import com.aiprteam.backend.dto.auth.LoginRequestDto;
import com.aiprteam.backend.dto.auth.RegisterRequestDto;
import com.aiprteam.backend.dto.auth.UserResponseDto;

public interface AuthService {
     UserResponseDto Register(RegisterRequestDto registerRequestDto);
     UserResponseDto getCurrentUser();
}
