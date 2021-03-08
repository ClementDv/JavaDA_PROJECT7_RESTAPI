package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.dto.UserUpdateDto;
import com.nnk.springboot.domain.entity.User;
import com.nnk.springboot.domain.mapper.CoreMapper;
import com.nnk.springboot.domain.mapper.UserMapper;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl extends CoreServiceImpl<UserDto, User, Integer> implements UserService {

    private final @Getter
    UserRepository repository;

    private final @Getter
    UserMapper mapper;
}
