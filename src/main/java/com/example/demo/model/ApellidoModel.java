package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApellidoModel {

    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    @JsonProperty("nombre_id")
    private Integer nombreId;

    public ApellidoModel() {
    }

    public ApellidoModel(String apellidoPaterno, String apellidoMaterno, Integer nombreId) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreId = nombreId;
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

    public Integer getNombreId() {
        return nombreId;
    }

    public void setNombreId(Integer nombreId) {
        this.nombreId = nombreId;
    }

}
