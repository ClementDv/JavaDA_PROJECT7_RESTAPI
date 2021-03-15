package com.nnk.springboot.controllers;

import com.nnk.springboot.config.AuthenticationMock;
import com.nnk.springboot.services.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private AuthenticationService authenticationService;


    @Test
    @AuthenticationMock.WithUserAuth
    void getHomeViewTest() throws Exception {
        mvc.perform(get("/poseidon/"))
                .andExpect(status().isOk()).andExpect(view().name("home"));

    }
}
