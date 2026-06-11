package io.github.lucasiferreira.catalogoapi.service;

import io.github.lucasiferreira.catalogoapi.exceptions.EntidadeExistenteException;
import io.github.lucasiferreira.catalogoapi.models.Usuario;
import io.github.lucasiferreira.catalogoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public void salvar(Usuario usuario) {
        if(userRepository.existsByLogin(usuario.getLogin())){
            throw new EntidadeExistenteException("Usuário já existente, tente outro nome de usuário!");
        }
        var senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        userRepository.save(usuario);
    }

    public Usuario obterPorLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
