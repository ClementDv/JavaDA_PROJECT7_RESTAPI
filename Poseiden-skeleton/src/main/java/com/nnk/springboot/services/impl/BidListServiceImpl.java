package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BidListServiceImpl extends CoreServiceImpl<BidList, Integer> implements BidListService {
    private final BidListRepository repository;

    public BidListServiceImpl(BidListRepository repository) {
        this.repository = repository;
    }

    @Override
    BidListRepository getRepository() {
        return repository;
    }
}
