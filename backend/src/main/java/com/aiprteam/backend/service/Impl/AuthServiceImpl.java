package com.aiprteam.backend.service.Impl;
import com.aiprteam.backend.dto.RegisterRequestDto;
import com.aiprteam.backend.dto.UserDto;
import com.aiprteam.backend.entity.Users;
import com.aiprteam.backend.mapper.AuthMapper;
import com.aiprteam.backend.repository.ProjectRepository;
import com.aiprteam.backend.repository.UsersRepository;
import com.aiprteam.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsersRepository userRepository;
    private  final ProjectRepository projectRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto Register(RegisterRequestDto dto) {
        Users user;
        user = authMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = userRepository.save(authMapper.toEntity(dto));
        return authMapper.toDto(user);
    }

    @Override
    public UserDto getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated())
            throw new UsernameNotFoundException("User not Found");

        String email =authentication.getName();

        Users user = userRepository.findByEmailAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return authMapper.toDto(user);
    }

    public void DeleteUser(){
          UserDto dto=  getCurrentUser();
          Users user = userRepository.findByEmailAddress(dto.getEmailAddress()). orElseThrow(() ->
                  new UsernameNotFoundException("User not found with email: " + dto.getEmailAddress()));
          userRepository.delete(user);
          SecurityContextHolder.clearContext();

    }

    }

