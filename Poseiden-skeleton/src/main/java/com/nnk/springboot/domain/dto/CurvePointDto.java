package com.nnk.springboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurvePointDto extends AbstractDto {

    @Positive(message = "CurveId must be positive")
    @NotNull(message = "CurveId is mandatory")
    private Integer curveId;

    private Timestamp asOfDate;

    @Positive(message = "Term must be positive")
    @NotNull(message = "Term is mandatory")
    private Double term;

    @Positive(message = "Value must be positive")
    @NotNull(message = "Value is mandatory")
    private Double value;
    private Timestamp creationDate;
}

