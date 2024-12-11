package com.example.demo.models.OperationsDto;

import java.util.List;

import com.example.demo.entity.Two;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TwoDto {

    @JsonProperty("message")
    private String result;
    @JsonProperty("values")
    private List<Two> two;

    public TwoDto(String result, List<Two> two) {
        this.result = result;
        this.two = two;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public List<Two> getTwo() {
        return two;
    }
    public void setTwo(List<Two> two) {
        this.two = two;
    }

}
