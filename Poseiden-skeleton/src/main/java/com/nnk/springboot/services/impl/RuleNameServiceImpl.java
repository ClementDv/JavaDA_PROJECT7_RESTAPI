package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.RuleNameDto;
import com.nnk.springboot.domain.entity.RuleName;
import com.nnk.springboot.domain.mapper.RuleNameMapper;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RuleNameServiceImpl extends CoreServiceImpl<RuleNameDto, RuleName, Integer> implements RuleNameService {

    private final @Getter
    RuleNameRepository repository;

    private final @Getter
    RuleNameMapper mapper;

    @Override
    protected String getName() {
        return "RuleName";
    }
}
