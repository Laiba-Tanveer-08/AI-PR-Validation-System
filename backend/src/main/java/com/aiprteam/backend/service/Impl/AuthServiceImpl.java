package com.aiprteam.backend.service.Impl;
import com.aiprteam.backend.dto.auth.*;
import com.aiprteam.backend.entity.Users;
import com.aiprteam.backend.mapper.AuthMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.UsersRepository;
import com.aiprteam.backend.service.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UsersRepository userRepository;
    private ProjectRepository projectRepository;
    private AuthMapper authMapper;
    @Override
    public UserDto Register(RegisterRequestDto dto) {
        Users user;
        user = userRepository.save(authMapper.toEntity(dto));
        return authMapper.toDto(user);
    }

    @Override
    public UserDto getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails)
            email = ((UserDetails) principal).getUsername();
        else {
            assert principal != null;
            email = principal.toString();
        }

        Users user = userRepository.findByEmailAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        return authMapper.toDto(user);

    }
    }

