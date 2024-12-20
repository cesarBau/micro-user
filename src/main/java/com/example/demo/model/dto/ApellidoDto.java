package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApellidoDto {

    private Integer id;
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    private String message;
    @JsonProperty("nombre_id")
    private Integer nombreId;

    public ApellidoDto() {
    }

    public ApellidoDto(Integer id, String apellidoPaterno, String apellidoMaterno, Integer nombreId) {
        this.id = id;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.message = "success";
        this.nombreId = nombreId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNombreId() {
        return nombreId;
    }

    public void setNombreId(Integer nombreId) {
        this.nombreId = nombreId;
    }

}
