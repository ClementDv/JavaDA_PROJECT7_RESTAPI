package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "moodysRating", nullable = false)
    private String moodysRating;

    @Column(name = "sandPRating", nullable = false)
    private String sandPRating;

    @Column(name = "fitchRating", nullable = false)
    private String fitchRating;

    @Column(name = "orderNumber", nullable = false)
    private int orderNumber;
}
