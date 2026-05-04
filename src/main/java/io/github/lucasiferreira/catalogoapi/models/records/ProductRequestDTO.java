package io.github.lucasiferreira.catalogoapi.models.records;

public record ProductRequestDTO(String name,
                                String description,
                                Double price,
                                Long quantity) {
}
