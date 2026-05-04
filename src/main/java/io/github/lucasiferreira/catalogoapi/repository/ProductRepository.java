package io.github.lucasiferreira.catalogoapi.repository;

import io.github.lucasiferreira.catalogoapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
