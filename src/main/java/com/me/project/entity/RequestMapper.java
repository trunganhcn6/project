package com.me.project.entity;

import com.me.project.web.payload.request.RequestDto;
import com.me.project.web.payload.request.StoreProductDTO;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RequestMapper {
    Request requestDtoToRequest(RequestDto requestDto);

    RequestDto requestToRequestDto(Request request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Request updateRequestFromRequestDto(RequestDto requestDto, @MappingTarget Request request);

    @AfterMapping
    default void linkRequestDetails(@MappingTarget Request request) {
        request.getRequestDetails().forEach(requestDetail -> requestDetail.setRequest(request));
    }

    StoreProduct storeProductDTOToStoreProduct(StoreProductDTO storeProductDTO);

    StoreProductDTO storeProductToStoreProductDTO(StoreProduct storeProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StoreProduct updateStoreProductFromStoreProductDTO(StoreProductDTO storeProductDTO, @MappingTarget StoreProduct storeProduct);

    @AfterMapping
    default void linkBrandProduct(@MappingTarget StoreProduct storeProduct) {
        BrandProduct brandProduct = storeProduct.getBrandProduct();
        if (brandProduct != null) {
            brandProduct.setStoreProduct(storeProduct);
        }
    }
}
