package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.dto.RuleNameDto;
import com.nnk.springboot.services.RuleNameService;
import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebMvcTest(RuleNameController.class)
public class RuleNameControllerTest extends AbstractCoreControllerTest {


    @MockBean
    @Getter
    private RuleNameService service;

    @Override
    protected String getServiceName() {
        return "ruleName";
    }

    @Override
    protected MultiValueMap<String, String> getValidMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("name", "TestName",
                "description", "TestDescp",
                "json", "TestJson",
                "template", "TestTemplate",
                "sqlStr", "TestSql",
                "sqlPart", "TestSql"));
        return multiValueMap;
    }

    @Override
    protected MultiValueMap<String, String> getWrongMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("name", "",
                "description", "",
                "json", "",
                "template", "",
                "sqlStr", "",
                "sqlPart", ""));
        return multiValueMap;
    }


    @Override
    protected AbstractDto getTestModel() {
        return new RuleNameDto();
    }
}
