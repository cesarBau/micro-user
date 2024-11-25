package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true, unique = false)
    private String idproveedor;
    @CreationTimestamp
    @Column(name="fecha_creacion", nullable = false, updatable = true, insertable = true)
    private LocalDateTime fechaCreacion;
    @CreationTimestamp
    @Column(name="fecha_activacion", nullable = true, updatable = true, insertable = true)
    private LocalDateTime fechaActivacion;
    @CreationTimestamp
    @Column(name="fecha_cancelacion", nullable = true, updatable = true, insertable = false)
    private LocalDateTime fechaCancelacion;
    @ManyToOne(targetEntity = EstatusSuscripcion.class)
    @JoinColumn(name = "estatus_suscripcion", referencedColumnName = "id")
    private EstatusSuscripcion estatusSuscripcion;
    @CreationTimestamp
    @Column(name="last_update", nullable = false, updatable = true, insertable = true)
    private LocalDateTime update;

    public Suscripcion() {
        this.id = 0;
        this.idproveedor = "";
        this.fechaCreacion = null;
        this.fechaActivacion = null;
        this.fechaCancelacion = null;
        this.estatusSuscripcion = new EstatusSuscripcion();
        this.update = null;
    }

    public Suscripcion(Integer id, String idproveedor, LocalDateTime fechaCreacion, LocalDateTime fechaActivacion,
            LocalDateTime fechaCancelacion, EstatusSuscripcion estatusSuscripcion, LocalDateTime update) {
        this.id = id;
        this.idproveedor = idproveedor;
        this.fechaCreacion = fechaCreacion;
        this.fechaActivacion = fechaActivacion;
        this.fechaCancelacion = fechaCancelacion;
        this.estatusSuscripcion = estatusSuscripcion;
        this.update = update;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIdproveedor() {
        return idproveedor;
    }
    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public LocalDateTime getFechaActivacion() {
        return fechaActivacion;
    }
    public void setFechaActivacion(LocalDateTime fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }
    public LocalDateTime getFechaCancelacion() {
        return fechaCancelacion;
    }
    public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }
    public EstatusSuscripcion getEstatusSuscripcion() {
        return estatusSuscripcion;
    }
    public void setEstatusSuscripcion(EstatusSuscripcion estatusSuscripcion) {
        this.estatusSuscripcion = estatusSuscripcion;
    }
    public LocalDateTime getUpdate() {
        return update;
    }
    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }
    
}
