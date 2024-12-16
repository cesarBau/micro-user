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
    private List<ObjApellidoDto> apellido;
    private String message;

    public NombreDto() {
    }

    public NombreDto(Integer id, String nombre, String segundoNombre, String idUsuario, List<ObjApellidoDto> apellido) {
        this.id = id;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.message = "success";
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

    public List<ObjApellidoDto> getApellido() {
        return apellido;
    }

    public void setApellido(List<ObjApellidoDto> apellido) {
        this.apellido = apellido;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
