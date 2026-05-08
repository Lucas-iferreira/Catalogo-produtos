package io.github.lucasiferreira.catalogoapi.service;

import io.github.lucasiferreira.catalogoapi.mapper.ProductMapper;
import io.github.lucasiferreira.catalogoapi.models.Product;
import io.github.lucasiferreira.catalogoapi.models.records.ProductRequest;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import io.github.lucasiferreira.catalogoapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        return mapper.toProductResponse(product);
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = mapper.toEntity(productRequest);
        productRepository.save(product);
        return mapper.toProductResponse(product);
    }
}
