package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.entity.Users;
import com.aiprteam.backend.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmailAddress(email).orElseThrow(()
                -> new UsernameNotFoundException(email));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmailAddress())
                .password(user.getPassword())
                .roles("USER") .build();
    }
    }
