package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.domain.entity.BidList;
import com.nnk.springboot.domain.mapper.BidListMapper;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class BidListServiceImpl extends CoreServiceImpl<BidListDto, BidList, Integer> implements BidListService {

    private final @Getter
    BidListRepository repository;

    private final @Getter
    BidListMapper mapper;


    @Override
    protected String getName() {
        return "BidList";
    }
}
