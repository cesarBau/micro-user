package com.example.demo.service;

import com.example.demo.entity.Usuario;

public interface IUsuarioService {

    Usuario createUser(Usuario usuario);
    Usuario getUserById(String id);
    Usuario updateUserById(String id);
    Usuario getUserByIdusuario(String idusuario);

}
