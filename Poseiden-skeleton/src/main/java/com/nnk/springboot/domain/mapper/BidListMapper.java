package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.domain.entity.BidList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BidListMapper extends CoreMapper<BidListDto, BidList> {
}
