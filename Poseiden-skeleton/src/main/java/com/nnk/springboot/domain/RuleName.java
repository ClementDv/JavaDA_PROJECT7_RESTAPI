package com.nnk.springboot.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "rulename")
public class RuleName extends AbstractEntity {

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
