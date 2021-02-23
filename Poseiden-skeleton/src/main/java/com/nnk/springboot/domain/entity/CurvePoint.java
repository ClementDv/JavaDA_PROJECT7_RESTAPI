package com.nnk.springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "curvepoint")
public class CurvePoint extends AbstractEntity {

    @Column(name = "curveId", nullable = false)
    private int curveId;

    @Column(name = "asOfDate")
    private Timestamp asOfDate;

    @Column(name = "term", nullable = false)
    private Double term;

    @Column(name = "value", nullable = false)
    private Double value;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Timestamp creationDate;
}
