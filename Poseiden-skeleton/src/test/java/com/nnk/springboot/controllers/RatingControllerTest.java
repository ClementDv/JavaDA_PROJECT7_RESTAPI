package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.services.RatingService;
import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebMvcTest(RatingController.class)
public class RatingControllerTest extends AbstractCoreControllerTest {

    @MockBean
    @Getter
    private RatingService service;

    @Override
    protected String getServiceName() {
        return "rating";
    }

    @Override
    protected MultiValueMap<String, String> getValidMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("moodysRating", "testRating",
                "sandPRating", "testRating",
                "fitchRating", "testRating",
                "orderNumber", "200"));
        return multiValueMap;
    }

    @Override
    protected MultiValueMap<String, String> getWrongMultiValueMap() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.setAll(Map.of("moodysRating", "",
                "sandPRating", "",
                "fitchRating", "",
                "orderNumber", "-200"));
        return multiValueMap;
    }

    @Override
    protected AbstractDto getTestModel() {
        return new RatingDto();
    }
}
