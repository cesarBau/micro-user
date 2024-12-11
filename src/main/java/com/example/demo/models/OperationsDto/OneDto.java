package com.example.demo.models.OperationsDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OneDto {

    private Integer id;
    private String name;
    @JsonProperty("two_values")
    private List<TwoObjtDto> twoValues;
    
    public OneDto(Integer id, String name, List<TwoObjtDto> twoValues) {
        this.id = id;
        this.name = name;
        this.twoValues = twoValues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TwoObjtDto> getTwoValues() {
        return twoValues;
    }

    public void setTwoValues(List<TwoObjtDto> twoValues) {
        this.twoValues = twoValues;
    }
    
}
