package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.domain.entity.BidList;
import com.nnk.springboot.domain.mapper.BidListMapper;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BidListServiceTest extends CoreServiceTest<BidListMapper, BidListRepository, BidListService, BidListDto, BidList> {

    @MockBean
    @Getter
    private BidListRepository repository;

    @Autowired
    @Getter
    private BidListService service;

    @Autowired
    @Getter
    private BidListMapper mapper;

    @Override
    protected BidList getTestEntity() {
        return new BidList().builder().id(1).account("accountTest").ask(100.02).askQuantity(100.03).build();
    }

    @Override
    protected List<BidList> getListTestEntity() {
        return new ArrayList<>(Arrays.asList(
                new BidList().builder().id(1).account("accountTest1").ask(100.00).askQuantity(99.99).build(),
                new BidList().builder().id(2).account("accountTest2").ask(200.01).askQuantity(100.00).build(),
                new BidList().builder().id(3).account("accountTest3").ask(300.02).askQuantity(101.00).build()
        ));
    }

    @Override
    protected BidListDto getTestModel() {
        return new BidListDto().builder().id(1).account("accountTest").ask(100.02).askQuantity(100.03).build();
    }

    @Override
    protected BidList getTestEntityToUpdate() {
        return new BidList().builder().id(1).account("update").ask(3030.00).askQuantity(2.99).build();
    }


}
