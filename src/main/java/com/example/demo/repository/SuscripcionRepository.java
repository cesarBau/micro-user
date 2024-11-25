package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Suscripcion;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer>{

    
    Suscripcion findByIdproveedor(String idproveedor);

}
