package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EstatusUsuario {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String descripcion;

    public EstatusUsuario() {
        this.id = 1;
        this.descripcion = "valido";
    }

    public EstatusUsuario(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
