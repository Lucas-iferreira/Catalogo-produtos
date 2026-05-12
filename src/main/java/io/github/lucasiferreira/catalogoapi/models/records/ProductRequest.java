package io.github.lucasiferreira.catalogoapi.models.records;

public record ProductRequest(String name,
                             String description,
                             Double price,
                             Long quantity,
                             boolean active,
                             Long categoryId) {
}
