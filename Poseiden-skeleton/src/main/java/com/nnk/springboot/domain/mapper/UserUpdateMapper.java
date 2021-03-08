package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.dto.UserUpdateDto;
import com.nnk.springboot.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserUpdateMapper extends CoreMapper<UserUpdateDto, UserDto> {
}
