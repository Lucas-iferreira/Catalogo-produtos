package io.github.lucasiferreira.catalogoapi.service;

import io.github.lucasiferreira.catalogoapi.models.Product;
import io.github.lucasiferreira.catalogoapi.models.records.CategoryResponse;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import io.github.lucasiferreira.catalogoapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                new CategoryResponse(product.getCategory().getId(), product.getCategory().getName())
        );
    }
}
