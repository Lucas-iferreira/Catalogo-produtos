package io.github.lucasiferreira.catalogoapi.service;

import io.github.lucasiferreira.catalogoapi.exceptions.EntidadeExistenteException;
import io.github.lucasiferreira.catalogoapi.exceptions.EntidadeNaoExisteException;
import io.github.lucasiferreira.catalogoapi.mapper.ProductMapper;
import io.github.lucasiferreira.catalogoapi.models.Category;
import io.github.lucasiferreira.catalogoapi.models.Product;
import io.github.lucasiferreira.catalogoapi.models.records.ProductRequest;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import io.github.lucasiferreira.catalogoapi.repository.CategoryRepository;
import io.github.lucasiferreira.catalogoapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Produto não encontrado!"));

        return mapper.toProductResponse(product);
    }

    @Transactional
    public ProductResponse create(ProductRequest productRequest) {
        if (productRepository.existsByName(productRequest.name())) {
            throw new EntidadeExistenteException("Entidade já existente!");
        }

        Category category = categoryRepository.findById(productRequest.categoryId())
                .orElseThrow(() -> new EntidadeNaoExisteException("Categoria não encontrada!"));

        Product product = mapper.toEntity(productRequest);
        product.setCategory(category);

        product = productRepository.save(product);
        return mapper.toProductResponse(product);
    }

    @Transactional
    public void update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Produto não encontrado!"));
        mapper.updateEntityFromProduct(productRequest, product);

        mapper.toProductResponse(productRepository.save(product));
    }

    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Produto não encontrado"));

        product.setActive(false);
        productRepository.save(product);
    }
}
