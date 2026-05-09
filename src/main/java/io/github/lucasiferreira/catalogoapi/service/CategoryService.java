package io.github.lucasiferreira.catalogoapi.service;

import io.github.lucasiferreira.catalogoapi.exceptions.EntidadeNaoExisteException;
import io.github.lucasiferreira.catalogoapi.models.Category;
import io.github.lucasiferreira.catalogoapi.models.records.CategoryRequest;
import io.github.lucasiferreira.catalogoapi.models.records.CategoryResponse;
import io.github.lucasiferreira.catalogoapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Categoria não encontrada!"));

        return new CategoryResponse(category.getId(), category.getName());
    }

    public void create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        categoryRepository.save(category);
    }
}
