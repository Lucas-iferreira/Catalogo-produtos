package io.github.lucasiferreira.catalogoapi.repository;

import io.github.lucasiferreira.catalogoapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);

    boolean existsByLogin(String login);

}
