package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.dto.TradeDto;
import com.nnk.springboot.services.TradeService;
import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebMvcTest(TradeController.class)
public class TradeControllerTest extends AbstractCoreControllerTest {

    @MockBean
    @Getter
    private TradeService service;

    @Override
    protected String getServiceName() {
        return "trade";
    }

    @Override
    protected MultiValueMap<String, String> getValidMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("account", "TestAcc",
                "type", "TestType",
                "buyQuantity", "200"));
        return multiValueMap;
    }

    @Override
    protected MultiValueMap<String, String> getWrongMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("account", "",
                "type", "",
                "buyQuantity", ""));
        return multiValueMap;
    }


    @Override
    protected AbstractDto getTestModel() {
        return new TradeDto();
    }
}
