package com.me.project.web.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link com.me.project.entity.Brand} entity
 */
@Data
public class BrandDTO implements Serializable {
    @NotBlank
    private final String name;
    @NotBlank
    private final String address;
}