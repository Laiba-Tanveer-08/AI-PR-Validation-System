package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.RegisterRequestDto;
import com.aiprteam.backend.dto.UserDto;

public interface AuthService {
     UserDto Register(RegisterRequestDto registerRequestDto);
     UserDto getCurrentUser();
     void DeleteUser();

}
