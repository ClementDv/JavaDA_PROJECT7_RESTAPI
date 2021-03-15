package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.entity.User;
import com.nnk.springboot.domain.mapper.UserMapper;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest extends CoreServiceTest<UserMapper, UserRepository, UserService, UserDto, User> {

    @MockBean
    @Getter
    private UserRepository repository;

    @Autowired
    @Getter
    private UserService service;

    @Autowired
    @Getter
    private UserMapper mapper;

    @Override
    protected User getTestEntity() {
        return new User().builder().id(1).fullname("FNtest").username("test").password("test-pwd").role("USER").build();
    }

    @Override
    protected List<User> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new User().builder().id(1).fullname("FNtest1").username("test1").password("test-pwd1").role("USER1").build(),
                new User().builder().id(2).fullname("FNtest2").username("test2").password("test-pwd2").role("USER2").build(),
                new User().builder().id(3).fullname("FNtest3").username("test3").password("test-pwd3").role("USER3").build()
        ));
    }

    @Override
    protected UserDto getTestModel() {
        return new UserDto().builder().id(10).fullname("FNtestdto").username("testdto").password("test-pwddto").role("USER").build();
    }

    @Override
    protected User getTestEntityToUpdate() {
        return new User().builder().id(100).fullname("FNtestupdt").username("testupdt").password("test-pwdupdt").role("ADMIN").build();
    }
}
