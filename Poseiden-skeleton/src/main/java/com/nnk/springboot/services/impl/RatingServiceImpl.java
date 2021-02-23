package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.domain.entity.Rating;
import com.nnk.springboot.domain.mapper.RatingMapper;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RatingServiceImpl extends CoreServiceImpl<RatingDto, Rating, Integer> implements RatingService {

    private final @Getter
    RatingRepository repository;

    private final @Getter
    RatingMapper mapper;
}
