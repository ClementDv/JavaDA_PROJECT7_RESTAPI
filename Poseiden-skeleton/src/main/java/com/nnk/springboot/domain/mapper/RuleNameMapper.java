package com.nnk.springboot.domain.mapper;

import com.nnk.springboot.domain.dto.RuleNameDto;
import com.nnk.springboot.domain.entity.RuleName;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RuleNameMapper extends CoreMapper<RuleNameDto, RuleName> {
}
