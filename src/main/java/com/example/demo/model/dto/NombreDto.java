package com.example.demo.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NombreDto {

    private Integer id;
    private String nombre;
    @JsonProperty("segundo_nombre")
    private String segundoNombre;
    @JsonProperty("usuario_id")
    private String idUsuario;
    private List<ApellidoDto> apellido;

    public NombreDto() {
    }

    public NombreDto(Integer id, String nombre, String segundoNombre, String idUsuario, List<ApellidoDto> apellido) {
        this.id = id;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.idUsuario = idUsuario;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ApellidoDto> getApellido() {
        return apellido;
    }

    public void setApellido(List<ApellidoDto> apellido) {
        this.apellido = apellido;
    }

}
