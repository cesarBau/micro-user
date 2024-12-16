package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Nombre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String segundoNombre;
    @Column(name = "usuario_id", nullable = false)
    private String usuario;
    @OneToMany(targetEntity = Apellido.class, mappedBy = "nombre", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Apellido> apellido;

    public Nombre() {
    }

    public Nombre(Integer id, String nombre, String segundoNombre, String usuario, List<Apellido> apellido) {
        this.id = id;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.usuario = usuario;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Apellido> getApellido() {
        return apellido;
    }

    public void setApellido(List<Apellido> apellido) {
        this.apellido = apellido;
    }

}
