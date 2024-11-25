package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUserById(String id) {
        Optional<Usuario> process = usuarioRepository.findById(id);
        Usuario result =  process.get();
        return result;
    }

    @Override
    public Usuario updateUserById(Usuario usuario, String id) {
        LocalDateTime now = LocalDateTime.now();
        Optional<Usuario> consult = usuarioRepository.findById(id);
        Usuario process =  consult.get();
        process.setIdusuario(usuario.getIdusuario());
        process.setEstatusUsuario(usuario.getEstatusUsuario());
        process.setUpdate(now);
        usuarioRepository.save(process);
        return process;
    }
}
