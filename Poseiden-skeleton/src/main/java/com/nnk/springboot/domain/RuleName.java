package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "rulename")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RuleName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "json", nullable = false)
    private String json;

    @Column(name = "template", nullable = false)
    private String template;

    @Column(name = "sqlStr", nullable = false)
    private String sqlStr;

    @Column(name = "sqlPart", nullable = false)
    private String sqlPart;
}
