package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.dto.CurvePointDto;
import com.nnk.springboot.services.CoreService;
import com.nnk.springboot.services.CurvePointService;
import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebMvcTest(CurveController.class)
public class CurveControllerTest extends AbstractCoreControllerTest {

    @MockBean
    @Getter
    private CurvePointService service;

    @Override
    protected String getServiceName() {
        return "curvePoint";
    }

    @Override
    protected MultiValueMap<String, String> getValidMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("curveId", "1",
                "term", "200",
                "value", "300.02"));
        return multiValueMap;
    }

    @Override
    protected MultiValueMap<String, String> getWrongMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("curveId", "1",
                "term", "",
                "value", ""));
        return multiValueMap;
    }

    @Override
    protected AbstractDto getTestModel() {
        return new CurvePointDto();
    }
}
