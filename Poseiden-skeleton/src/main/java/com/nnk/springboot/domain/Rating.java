package com.nnk.springboot.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating extends AbstractEntity {

    @Column(name = "moodysRating", nullable = false)
    private String moodysRating;

    @Column(name = "sandPRating", nullable = false)
    private String sandPRating;

    @Column(name = "fitchRating", nullable = false)
    private String fitchRating;

    @Column(name = "orderNumber", nullable = false)
    private int orderNumber;
}
