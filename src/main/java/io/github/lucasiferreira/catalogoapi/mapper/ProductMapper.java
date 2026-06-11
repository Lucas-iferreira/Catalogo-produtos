package io.github.lucasiferreira.catalogoapi.mapper;

import io.github.lucasiferreira.catalogoapi.models.Product;
import io.github.lucasiferreira.catalogoapi.models.records.ProductRequest;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toProductResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductRequest productRequest);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    void updateEntityFromProduct(ProductRequest productRequest, @MappingTarget Product product);
}
