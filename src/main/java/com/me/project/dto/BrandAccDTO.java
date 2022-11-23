package com.me.project.dto;

import com.me.project.entity.BrandAcc;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link BrandAcc} entity
 */
@Data
public class BrandAccDTO implements Serializable {

    private final String username;
    @Email
    private final String email;

    @NotBlank
    private final String password;

    @NotBlank
    private final Integer brandId;
}