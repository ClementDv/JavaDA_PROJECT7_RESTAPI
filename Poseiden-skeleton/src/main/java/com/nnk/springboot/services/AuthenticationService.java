package com.nnk.springboot.services;

import com.nnk.springboot.domain.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    UserDto registerUser(UserDto userRegisterDto);

    UserDetails loadUserByUsername(String username);
}
