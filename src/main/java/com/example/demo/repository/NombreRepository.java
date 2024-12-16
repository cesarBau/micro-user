package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nombre;

public interface NombreRepository extends JpaRepository<Nombre, Integer>{

    List<Nombre> getByNombre(String nombre);

}
