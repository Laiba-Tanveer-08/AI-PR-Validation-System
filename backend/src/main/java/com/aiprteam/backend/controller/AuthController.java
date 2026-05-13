package com.aiprteam.backend.controller;

import com.aiprteam.backend.dto.RegisterRequestDto;
import com.aiprteam.backend.dto.UserDto;
import com.aiprteam.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(
            @RequestBody RegisterRequestDto dto
    ) {

        UserDto createdUser = authService.Register(dto);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
