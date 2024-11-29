package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.service.IUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
public class UsuarioController {

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private final IUsuarioService iusuarioService;

    public UsuarioController(IUsuarioService iusuarioService) {
        this.iusuarioService = iusuarioService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Usuario postMethodName(@RequestBody Usuario user) {
        return iusuarioService.createUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Usuario getUserByIdusuario(@PathVariable String id) {
        logger.info("Consume controller getUserByIdusuario");
        return iusuarioService.getUserByIdusuario(id);
    }

    @GetMapping("/idproveedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Usuario getUserByIdproveedor(@PathVariable String id) {
        logger.info("Consume controller getUserByIdproveedor");
        logger.info(id);
        return iusuarioService.getUserById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Usuario updateUserById(@PathVariable String id){
        return iusuarioService.updateUserById(id);
    }
    
}
