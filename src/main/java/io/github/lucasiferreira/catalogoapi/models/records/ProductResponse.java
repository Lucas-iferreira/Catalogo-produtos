package io.github.lucasiferreira.catalogoapi.models.records;

public record ProductResponse(Long id,
                              String name,
                              String description,
                              Double price,
                              Long quantity,
                              boolean active,
                              CategoryResponse category
) {
}
