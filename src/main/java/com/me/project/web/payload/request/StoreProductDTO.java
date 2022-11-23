package com.me.project.web.payload.request;

import com.me.project.entity.BrandProduct;
import com.me.project.entity.RequestDetails;
import com.me.project.entity.Store;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

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
    private final Store store;
    private final Set<RequestDetails> requestDetails;
    private final BrandProduct brandProduct;
}