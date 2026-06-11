package io.github.lucasiferreira.catalogoapi.controller;

import io.github.lucasiferreira.catalogoapi.models.records.ProductRequest;
import io.github.lucasiferreira.catalogoapi.models.records.ProductResponse;
import io.github.lucasiferreira.catalogoapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {

        ProductResponse productResponse = productService.findById(id);
        return ResponseEntity.ok(productResponse);
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Page<ProductResponse>> findAll(@RequestParam int pagina,
                                                         @RequestParam int tamanho) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pagina, tamanho));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> save(@RequestBody ProductRequest productRequest) {
        productService.create(productRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).build();
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        productService.update(id, productRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().toUri();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).location(uri).build();

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
