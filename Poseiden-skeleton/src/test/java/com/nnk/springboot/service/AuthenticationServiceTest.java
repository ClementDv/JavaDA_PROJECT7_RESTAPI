package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.entity.User;
import com.nnk.springboot.domain.mapper.UserMapper;
import com.nnk.springboot.exceptions.UserAlreadyExistsException;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@SpringBootTest
public class AuthenticationServiceTest {

    @MockBean
    private UserRepository repository;

    @Autowired
    private AuthenticationService service;

    @Autowired
    private UserMapper mapper;

    @Test
    void registerUserTest() {
        UserDto userDto = getTestUserDto();

        Mockito.when(repository.existsByUsername(userDto.getUsername())).thenReturn(false);
        Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(mapper.fromModel(userDto.setRole("USER")));
        UserDto answer = service.registerUser(userDto.setRole(null));
        Assertions.assertEquals(userDto.setRole("USER"), answer);

        Mockito.when(repository.existsByUsername(userDto.getUsername())).thenReturn(true);
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
            service.registerUser(userDto);
        });
    }


    @Test
    void loadUserByUsernameTest() {
        UserDto userDto = getTestUserDto();

        Mockito.when(repository.findByUsername(userDto.getUsername())).thenReturn(mapper.fromModel(userDto));
        UserDetails answer = service.loadUserByUsername(userDto.getUsername());
        UserDetails userDetailsTest = new org.springframework.security.core.userdetails.User(
                userDto.getUsername(),
                userDto.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userDto.getRole())));
        Assertions.assertEquals(userDetailsTest, answer);

        Mockito.when(repository.findByUsername(userDto.getUsername())).thenReturn(mapper.fromModel(null));
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername(userDto.getUsername());
        });
    }

    private UserDto getTestUserDto() {
        return new UserDto().builder().fullname("FNtest").username("test").password("test-pwd").role("USER").build();
    }

}
