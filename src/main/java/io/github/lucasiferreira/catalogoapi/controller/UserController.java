package io.github.lucasiferreira.catalogoapi.controller;

import io.github.lucasiferreira.catalogoapi.mapper.UserMapper;
import io.github.lucasiferreira.catalogoapi.models.records.UsuarioRequest;
import io.github.lucasiferreira.catalogoapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UserMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasRole('ADMIN')")
    public void salvar(@RequestBody UsuarioRequest request) {
        var usuario = mapper.toEntity(request);
        usuarioService.salvar(usuario);
    }
}
