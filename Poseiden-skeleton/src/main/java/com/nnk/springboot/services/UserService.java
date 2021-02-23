package com.nnk.springboot.services;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.entity.User;

public interface UserService extends CoreService<UserDto, User, Integer> {
}
