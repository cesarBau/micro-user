package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Nombre;

public interface INombreService {

    Nombre createNombre(Nombre nombre);
    Nombre getNombreById(Integer id);
    List<Nombre> getNombreByNombre(String nombre);
    Nombre updateNombre(Integer id, Nombre nombre);
    void deleteNombre(Integer id);

}
