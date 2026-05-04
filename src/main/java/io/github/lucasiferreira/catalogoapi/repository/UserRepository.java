package io.github.lucasiferreira.catalogoapi.repository;

import io.github.lucasiferreira.catalogoapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
