package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NombreModel {

    private String nombre;
    @JsonProperty("segundo_nombre")
    private String segundoNombre;
    @JsonProperty("usuario_id")
    private String usuarioId;
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;

    public NombreModel() {
    }

    public NombreModel(String nombre, String segundoNombre, String usuarioId, String apellidoPaterno,
            String apellidoMaterno) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.usuarioId = usuarioId;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
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

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
