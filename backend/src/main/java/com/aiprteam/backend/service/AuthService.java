package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.auth.RegisterRequestDto;
import com.aiprteam.backend.dto.auth.UserDto;

public interface AuthService {
     UserDto Register(RegisterRequestDto registerRequestDto);
     UserDto getCurrentUser();

}
