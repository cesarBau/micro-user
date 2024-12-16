package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Apellido;

public interface ApellidoRepository extends JpaRepository<Apellido, Integer>{

    List<Apellido> getByApellido(String apellido);

}
