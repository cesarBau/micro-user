package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Apellido;

public interface ApellidoRepository extends JpaRepository<Apellido, Integer>{

    List<Apellido> getByApellido(String apellido);
    @Query("SELECT a FROM Apellido a WHERE a.nombre.id = ?1")
    List<Apellido> findByNombre(Integer nombreId);

}
