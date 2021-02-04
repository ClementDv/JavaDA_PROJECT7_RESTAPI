package com.nnk.springboot.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bidlist")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BidList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "bidQuantity", nullable = false)
    private Double bidQuantity;

    @Column(name = "askQuantity", nullable = false)
    private Double askQuantity;

    @Column(name = "bid", nullable = false)
    private Double bid;

    @Column(name = "ask", nullable = false)
    private Double ask;

    @Column(name = "benchmark", nullable = false)
    private String benchmark;

    @Column(name = "bidListDate", nullable = false)
    private Timestamp bidListDate;

    @Column(name = "commentary", nullable = false)
    private String commentary;

    @Column(name = "security", nullable = false)
    private String security;

    @Column(name = "trader", nullable = false)
    private String trader;

    @Column(name = "Book", nullable = false)
    private String Book;

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
