package com.nnk.springboot.domain.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractDto {
    private Integer id;
}
