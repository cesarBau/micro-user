package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Apellido;

public interface IApellidoService {

    Apellido creatApellido(Apellido apellido);
    Apellido getApellidoById(Integer id);
    List<Apellido> getApellidoByApellido(String apellido);

}
