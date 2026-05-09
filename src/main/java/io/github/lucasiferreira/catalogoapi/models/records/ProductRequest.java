package io.github.lucasiferreira.catalogoapi.models.records;

import io.github.lucasiferreira.catalogoapi.models.Category;

public record ProductRequest(String name,
                             String description,
                             Double price,
                             Long quantity,
                             Category category) {
}
