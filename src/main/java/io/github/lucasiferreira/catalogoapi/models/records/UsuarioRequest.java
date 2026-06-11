package io.github.lucasiferreira.catalogoapi.models.records;

import java.util.List;

public record UsuarioRequest(String login, String senha, List<String> roles) {
}
