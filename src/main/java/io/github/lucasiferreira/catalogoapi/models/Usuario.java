package io.github.lucasiferreira.catalogoapi.models;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "tb_users")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String senha;

    @Type(ListArrayType.class)
    @Column(name = "roles", columnDefinition = "varchar[]") //hibernate não saberá traduzir isso, deverá ter a biblioteca hipersistence utilz (vladimir)
    private List<String> roles;
}
