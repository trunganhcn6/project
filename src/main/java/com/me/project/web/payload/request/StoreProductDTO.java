package com.me.project.web.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.me.project.entity.StoreProduct} entity
 */
@Data
public class StoreProductDTO implements Serializable {
    @NotNull
    @NotBlank
    private final Integer quantity;
    @NotBlank
    private final String name;
    @NotBlank
    private final Integer price;
}