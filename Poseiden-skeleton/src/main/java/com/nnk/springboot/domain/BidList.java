package com.nnk.springboot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "bidlist")
public class BidList extends AbstractEntity {

    @NonNull
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
