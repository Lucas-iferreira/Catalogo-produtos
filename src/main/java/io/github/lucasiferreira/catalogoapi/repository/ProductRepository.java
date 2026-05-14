package io.github.lucasiferreira.catalogoapi.repository;

import io.github.lucasiferreira.catalogoapi.models.Product;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    Page<Product> findAll(@NonNull Pageable pageable);
}
