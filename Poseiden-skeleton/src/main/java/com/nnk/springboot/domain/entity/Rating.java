package com.nnk.springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
