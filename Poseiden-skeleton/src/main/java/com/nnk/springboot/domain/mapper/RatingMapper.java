package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.domain.entity.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper extends CoreMapper<RatingDto, Rating> {
}
