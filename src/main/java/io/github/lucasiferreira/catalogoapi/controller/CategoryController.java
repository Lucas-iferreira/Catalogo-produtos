package io.github.lucasiferreira.catalogoapi.controller;

import io.github.lucasiferreira.catalogoapi.models.records.CategoryRequest;
import io.github.lucasiferreira.catalogoapi.models.records.CategoryResponse;
import io.github.lucasiferreira.catalogoapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        CategoryResponse categoryResponse = categoryService.findById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CategoryRequest categoryRequest) {
        return null;
    }
}
