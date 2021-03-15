package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.TradeDto;
import com.nnk.springboot.domain.entity.Trade;
import com.nnk.springboot.domain.mapper.TradeMapper;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TradeServiceTest extends CoreServiceTest<TradeMapper, TradeRepository, TradeService, TradeDto, Trade> {

    @MockBean
    @Getter
    private TradeRepository repository;

    @Autowired
    @Getter
    private TradeService service;

    @Autowired
    @Getter
    private TradeMapper mapper;

    @Override
    protected Trade getTestEntity() {
        return new Trade().builder().id(1).account("test").type("testtype").buyQuantity(99.99).build();
    }

    @Override
    protected List<Trade> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new Trade().builder().id(1).account("test1").type("testtype1").buyQuantity(99.99).build(),
                new Trade().builder().id(2).account("test2").type("testtype2").buyQuantity(999.99).build(),
                new Trade().builder().id(3).account("test3").type("testtype3").buyQuantity(9999.99).build()
        ));
    }

    @Override
    protected TradeDto getTestModel() {
        return new TradeDto().builder().id(10).account("testdto").type("testtypedto").buyQuantity(10000D).build();
    }

    @Override
    protected Trade getTestEntityToUpdate() {
        return new Trade().builder().id(10).account("testupdt").type("testtypeupdt").buyQuantity(99D).build();
    }
}
