package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.CoreService;
import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebMvcTest(BidListController.class)
public class BidListControllerTest extends AbstractCoreControllerTest {

    @MockBean
    @Getter
    protected BidListService service;

    @Override
    protected String getServiceName() {
        return "bidList";
    }

    @Override
    protected MultiValueMap<String, String> getValidMultiValueMap() {
         MultiValueMap multiValueMap = new LinkedMultiValueMap();
         multiValueMap.setAll(Map.of("account", "TestAcc",
                "type", "TestType",
                "bidQuantity", "300.02"));
        return multiValueMap;
    }

    @Override
    protected MultiValueMap<String, String> getWrongMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("account", "",
                "type", "",
                "bidQuantity", "-300.1"));
        return multiValueMap;
    }

    @Override
    protected AbstractDto getTestModel() {
        return new BidListDto();
    }
}
