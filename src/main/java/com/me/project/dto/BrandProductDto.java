package com.me.project.dto;

import com.me.project.entity.BrandProduct;
import com.me.project.entity.Color;
import com.me.project.entity.Size;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link BrandProduct} entity
 */
@Data
public class BrandProductDto implements Serializable {
    @NotBlank
    private final String name;
    private final String description;
    @NotBlank
    private final Integer pricePerUnit;
    @NotBlank
    private final Integer timeToProduce;
    @NotBlank
    private final Size size;
    @NotBlank
    private final Color color;
}