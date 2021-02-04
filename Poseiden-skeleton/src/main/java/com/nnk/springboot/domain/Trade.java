package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.sql.Timestamp;


@Entity
@Table(name = "trade")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "buyQuantity", nullable = false)
    private Double buyQuantity;

    @Column(name = "sellQuantity", nullable = false)
    private Double sellQuantity;

    @Column(name = "buyPrice", nullable = false)
    private Double buyPrice;

    @Column(name = "sellPrice", nullable = false)
    private Double sellPrice;

    @Column(name = "benchmark", nullable = false)
    private String benchmark;

    @Column(name = "tradeDate", nullable = false)
    private Timestamp tradeDate;

    @Column(name = "security", nullable = false)
    private String security;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "trader", nullable = false)
    private String trader;

    @Column(name = "book", nullable = false)
    private String book;

    @Column(name = "creationName", nullable = false)
    private String creationName;

    @Column(name = "creationDate", nullable = false)
    private Timestamp creationDate;

    @Column(name = "revisionName", nullable = false)
    private String revisionName;

    @Column(name = "revisionDate", nullable = false)
    private Timestamp revisionDate;

    @Column(name = "dealName", nullable = false)
    private String dealName;

    @Column(name = "dealType", nullable = false)
    private String dealType;

    @Column(name = "sourceListId", nullable = false)
    private String sourceListId;

    @Column(name = "side", nullable = false)
    private String side;
}
