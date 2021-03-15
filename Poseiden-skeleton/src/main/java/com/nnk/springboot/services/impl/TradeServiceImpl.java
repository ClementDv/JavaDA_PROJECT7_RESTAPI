package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.TradeDto;
import com.nnk.springboot.domain.entity.Trade;
import com.nnk.springboot.domain.mapper.TradeMapper;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TradeServiceImpl extends CoreServiceImpl<TradeDto, Trade, Integer> implements TradeService {

    private final @Getter
    TradeRepository repository;

    private final @Getter
    TradeMapper mapper;

    @Override
    protected String getName() {
        return "Trade";
    }
}
