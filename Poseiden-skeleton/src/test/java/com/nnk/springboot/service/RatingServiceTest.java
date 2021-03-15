package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.domain.entity.Rating;
import com.nnk.springboot.domain.mapper.RatingMapper;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RatingServiceTest extends CoreServiceTest<RatingMapper, RatingRepository, RatingService, RatingDto, Rating> {

    @MockBean
    @Getter
    private RatingRepository repository;

    @Autowired
    @Getter
    private RatingService service;

    @Autowired
    @Getter
    private RatingMapper mapper;

    @Override
    protected Rating getTestEntity() {
        return new Rating().builder().id(1).moodysRating("MratingTest").sandPRating("PratingTest")
                .fitchRating("FratingTest").orderNumber(10).build();
    }

    @Override
    protected List<Rating> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new Rating().builder().id(1).moodysRating("MratingTest1").sandPRating("PratingTest1")
                        .fitchRating("FratingTest1").orderNumber(10).build(),
                new Rating().builder().id(2).moodysRating("MratingTest2").sandPRating("PratingTest2")
                        .fitchRating("FratingTest2").orderNumber(20).build(),
                new Rating().builder().id(3).moodysRating("MratingTest3").sandPRating("PratingTest3")
                        .fitchRating("FratingTest3").orderNumber(30).build()
        ));
    }

    @Override
    protected RatingDto getTestModel() {
        return new RatingDto().builder().id(3).moodysRating("MratingTestdto").sandPRating("PratingTestdto")
                .fitchRating("FratingTestdto").orderNumber(100).build();
    }

    @Override
    protected Rating getTestEntityToUpdate() {
        return new Rating().builder().id(10).moodysRating("MratingTestupdt").sandPRating("PratingTestudpt")
                .fitchRating("FratingTestupdt").orderNumber(1000).build();
    }
}
