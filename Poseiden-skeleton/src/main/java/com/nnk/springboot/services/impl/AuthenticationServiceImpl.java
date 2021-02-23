package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.entity.User;
import com.nnk.springboot.domain.mapper.UserMapper;
import com.nnk.springboot.exceptions.UserAlreadyExistsException;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nnk.springboot.services.AuthenticationService;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private UserMapper userMapper;

    public AuthenticationServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UserAlreadyExistsException("Le user " + userDto.getUsername() + " existe déjà!");
        }
        User user = userMapper.fromModel(userDto);
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toModel(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }
}
