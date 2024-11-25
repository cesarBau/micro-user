package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idproveedor;
    @Column(nullable = true)
    private String idusuario;
    @CreationTimestamp
    @Column(name="fecha_creacion", nullable = true, updatable = false, insertable = true)
    private LocalDateTime fechaCreacion;
    @Column(nullable = true)
    private Integer estatusUsuario;
    @CreationTimestamp
    @Column(name="last_update", nullable = false, updatable = true, insertable = true)
    private LocalDateTime update;
    
    public String getIdproveedor() {
        return idproveedor;
    }
    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }
    public String getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Integer getEstatusUsuario() {
        return estatusUsuario;
    }
    public void setEstatusUsuario(Integer estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }
    public LocalDateTime getUpdate() {
        return update;
    }
    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    public Usuario(String idproveedor, String idusuario, LocalDateTime fechaCreacion, Integer estatusUsuario,
            LocalDateTime update) {
        this.idproveedor = idproveedor;
        this.idusuario = idusuario;
        this.fechaCreacion = fechaCreacion;
        this.estatusUsuario = estatusUsuario;
        this.update = update;
    }

    public Usuario() {
    }

}
