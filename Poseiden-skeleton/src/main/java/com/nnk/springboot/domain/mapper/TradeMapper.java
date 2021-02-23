package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.TradeDto;
import com.nnk.springboot.domain.entity.Trade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TradeMapper extends CoreMapper<TradeDto, Trade> {
}
