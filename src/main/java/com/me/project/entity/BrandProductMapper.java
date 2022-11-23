package com.me.project.entity;

import com.me.project.dto.BrandProductDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BrandProductMapper {
    BrandProduct brandProductDtoToBrandProduct(BrandProductDto brandProductDto);

    BrandProductDto brandProductToBrandProductDto(BrandProduct brandProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BrandProduct updateBrandProductFromBrandProductDto(BrandProductDto brandProductDto, @MappingTarget BrandProduct brandProduct);
}
