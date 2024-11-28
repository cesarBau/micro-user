package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        logger.info("Consume service createUser");
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUserById(String id) {
        logger.info("Consume service getUserById");
        try {
            Optional<Usuario> process = usuarioRepository.findById(id);
            Usuario result =  process.get();
            return result;  
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "User not found", e);
        }  
    }

    @Override
    public Usuario updateUserById(Usuario usuario, String id) {
        logger.info("Consume service updateUserById");
        LocalDateTime now = LocalDateTime.now();
        try {
            Optional<Usuario> consult = usuarioRepository.findById(id);
            Usuario process =  consult.get();
            process.setEstatusUsuario(usuario.getEstatusUsuario());
            process.setUpdate(now);
            usuarioRepository.save(process);
            return process;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "User not found", e);
        } 
    }

    @Override
    public Usuario getUserByIdusuario(String idusuario) {
        logger.info("Consume service getUserByIdusuario");
        Usuario consult = usuarioRepository.findByIdusuario(idusuario);
        if (consult == null){
            logger.info(String.format("El usuario /%s no existe", idusuario));
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "User not found", null);
        } else {
            logger.info(String.format("El usuario %s existe en DB", idusuario));
            return consult;
        }
    }
}
