package io.github.lucasiferreira.catalogoapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Long quantity;
}
