package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CurvePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "curveId", nullable = false)
    private int curveId;

    @Column(name = "asOfDate", nullable = false)
    private Timestamp asOfDate;

    @Column(name = "term", nullable = false)
    private Double term;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "creationDate", nullable = false)
    private Timestamp creationDate;
}
