package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.CurvePointDto;
import com.nnk.springboot.domain.entity.CurvePoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurvePointMapper extends CoreMapper<CurvePointDto, CurvePoint> {
}
