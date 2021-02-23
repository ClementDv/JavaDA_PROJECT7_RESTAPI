package com.nnk.springboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Integer id;
    private String moodysRating;
    private String sandPRating;
    private String fitchRating;
    private int orderNumber;
}
