package com.nnk.springboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class UserUpdateDto extends AbstractDto {

        @NotBlank(message = "Fullname is mandatory")
        private String fullname;

        @NotBlank(message = "Username is mandatory")
        private String username;

        private String password;

        @NotBlank(message = "Role is mandatory")
        private String role;
}
