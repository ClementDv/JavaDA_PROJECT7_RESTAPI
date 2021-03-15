package com.nnk.springboot.controllers;

import com.nnk.springboot.config.AuthenticationMock;
import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.entity.AbstractEntity;
import com.nnk.springboot.exceptions.EntityNotFoundException;
import com.nnk.springboot.exceptions.InvalidModelException;
import com.nnk.springboot.services.AuthenticationService;
import com.nnk.springboot.services.CoreService;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@AuthenticationMock.WithUserAuth
public abstract class AbstractCoreControllerTest<Service extends CoreService<Model, Entity, ID>, Model extends AbstractDto, Entity extends AbstractEntity, ID> {

    protected abstract String getServiceName();

    protected abstract MultiValueMap<String, String> getValidMultiValueMap();

    protected abstract MultiValueMap<String, String> getWrongMultiValueMap();

    protected abstract Service getService();

    protected abstract Model getTestModel();

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private AuthenticationService authenticationService;

    @Test
    void getHomeListTest() throws Exception {
        mvc.perform(get("/poseidon/" + getServiceName() + "/list"))
                .andExpect(status().isOk()).andExpect(view().name(getServiceName() + "/list"));

    }

    @Test
    void addEntityTest() throws Exception {
        mvc.perform(get("/poseidon/" + getServiceName() + "/add"))
                .andExpect(status().isOk()).andExpect(view().name(getServiceName() + "/add"));

    }

    @Test
    void createEntityTest() throws Exception {
        // Test success

        mvc.perform(post("/poseidon/" + getServiceName() + "/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).params(getValidMultiValueMap()).with(csrf()))
                .andExpect(status().isFound()).andExpect(view().name("redirect:/poseidon/" + getServiceName() + "/list"));

        // Test error (binding result)

        mvc.perform(post("/poseidon/" + getServiceName() + "/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).params(getWrongMultiValueMap()).with(csrf()))
                .andExpect(status().isOk()).andExpect(view().name(getServiceName() + "/add"));

    }

    @Test
    void UpdateFormTest() throws Exception {
        Mockito.when(getService().read(Mockito.any())).thenReturn(getTestModel());
        mvc.perform(get("/poseidon/" + getServiceName() + "/{id}", 1))
                .andExpect(status().isOk()).andExpect(view().name(getServiceName() + "/update"));

    }

    @Test
    void updateEntityTest() throws Exception {
        // Test success

        mvc.perform(put("/poseidon/" + getServiceName() + "/{id}", 1)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).params(getValidMultiValueMap()).with(csrf()))
                .andExpect(status().isFound()).andExpect(view().name("redirect:/poseidon/" + getServiceName() + "/list"));


        // Test error

        mvc.perform(put("/poseidon/" + getServiceName() + "/{id}", 1)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).params(getWrongMultiValueMap()).with(csrf()))
                .andExpect(status().isOk()).andExpect(view().name( getServiceName() + "/update"));

    }

    @Test
    void deleteTest() throws Exception {
        mvc.perform(delete("/poseidon/" + getServiceName() + "/{id}", 1).with(csrf()))
                .andExpect(status().isFound()).andExpect(view().name("redirect:/poseidon/" + getServiceName() + "/list"));

    }

    @Test
    void ExceptionTest() throws Exception {
        // EntityNotFoundException

        Mockito.when(getService().read(Mockito.any())).thenThrow(EntityNotFoundException.class);
        mvc.perform(get("/poseidon/" + getServiceName() + "/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));

        // InvalidModelException

        Mockito.when(getService().create(Mockito.any())).thenThrow(InvalidModelException.class);
        mvc.perform(post("/poseidon/" + getServiceName() + "/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).params(getValidMultiValueMap()).with(csrf()))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidModelException));

    }
}
