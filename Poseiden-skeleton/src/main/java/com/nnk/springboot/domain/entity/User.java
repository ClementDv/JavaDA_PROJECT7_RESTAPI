package com.nnk.springboot.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "username", nullable = false, unique = true)
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Column(name = "fullname", nullable = false)
    @NotBlank(message = "FullName is mandatory")
    private String fullname;

    @Column(name = "role", nullable = false)
    @NotBlank(message = "Role is mandatory")
    private String role;
}
