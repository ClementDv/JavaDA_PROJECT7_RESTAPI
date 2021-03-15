package com.nnk.springboot.controllers;

import com.nnk.springboot.config.AuthenticationMock;
import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.exceptions.InvalidModelException;
import com.nnk.springboot.exceptions.UserAlreadyExistsException;
import com.nnk.springboot.services.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@AuthenticationMock.WithUserAuth
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @MockBean
    private AuthenticationService authenticationService;

    @Autowired
    protected MockMvc mvc;

    @Test
    void RegisterFormTest() throws Exception {
        mvc.perform(get("/poseidon/register"))
                .andExpect(status().isOk()).andExpect(view().name("register/registerForm"));

    }

    @Test
    void RegisterTest() throws Exception {

        // Test success

        mvc.perform(post("/poseidon/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("fullname", "testfn")
                .param("username", "Testu")
                .param("password", "a$B8cdefg").with(csrf()))
                .andExpect(status().isFound()).andExpect(view().name("redirect:register?success"));

        // Test error (binding result)

        mvc.perform(post("/poseidon/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("fullname", "")
                .param("username", "")
                .param("password", "").with(csrf()))
                .andExpect(status().isOk()).andExpect(view().name("register/registerForm"));

        // Test exceptions

        Mockito.when(authenticationService.registerUser(Mockito.any(UserDto.class))).thenThrow(UserAlreadyExistsException.class);
        mvc.perform(post("/poseidon/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("fullname", "testfn")
                .param("username", "Testu")
                .param("password", "a$B8cdefg").with(csrf()))
                .andExpect(status().isFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserAlreadyExistsException));

    }

}
