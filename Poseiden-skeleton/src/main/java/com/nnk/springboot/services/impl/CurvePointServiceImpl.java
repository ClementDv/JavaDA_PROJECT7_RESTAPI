package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.CurvePointDto;
import com.nnk.springboot.domain.entity.CurvePoint;
import com.nnk.springboot.domain.mapper.CurvePointMapper;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CurvePointServiceImpl extends CoreServiceImpl<CurvePointDto, CurvePoint, Integer> implements CurvePointService {

    private final @Getter
    CurvePointRepository repository;

    private final @Getter
    CurvePointMapper mapper;

    @Override
    protected String getName() {
        return "CurvePoint";
    }
}
