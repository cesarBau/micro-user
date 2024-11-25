package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EstatusSuscripcion {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String descripcion;

    public EstatusSuscripcion() {
        this.id = 1;
        this.descripcion = "activo";
    }
    
    public EstatusSuscripcion(Integer id, String descripcion) {
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
