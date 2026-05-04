package io.github.lucasiferreira.catalogoapi.models.records;

public record ProductResponseDTO(Long id,
                                 String name,
                                 String description,
                                 Double price,
                                 Long quantity) {
}
