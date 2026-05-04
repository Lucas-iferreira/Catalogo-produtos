package io.github.lucasiferreira.catalogoapi.repository;

import io.github.lucasiferreira.catalogoapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
