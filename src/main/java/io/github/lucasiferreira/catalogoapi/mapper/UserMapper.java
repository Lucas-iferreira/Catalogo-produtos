package io.github.lucasiferreira.catalogoapi.mapper;

import io.github.lucasiferreira.catalogoapi.models.Usuario;
import io.github.lucasiferreira.catalogoapi.models.records.UsuarioRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Usuario toEntity(UsuarioRequest usuarioRequest);
}
