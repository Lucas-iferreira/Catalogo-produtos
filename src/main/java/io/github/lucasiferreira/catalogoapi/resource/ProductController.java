package io.github.lucasiferreira.catalogoapi.resource;

import io.github.lucasiferreira.catalogoapi.models.Product;
import io.github.lucasiferreira.catalogoapi.models.records.CategoryResponse;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import io.github.lucasiferreira.catalogoapi.service.CategoryService;
import io.github.lucasiferreira.catalogoapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id);
        return ResponseEntity.ok(productResponse);
    }
}
