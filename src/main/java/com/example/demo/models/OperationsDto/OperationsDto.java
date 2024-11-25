package com.example.demo.models.OperationsDto;

public class OperationsDto {

    private String name;
    private int valueOne;
    private int valueTwo;
    private int result;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setValueOne(int valueOne) {
        this.valueOne = valueOne;
    }
    public void setValueTwo(int valueTwo) {
        this.valueTwo = valueTwo;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public String getName() {
        return name;
    }
    public int getValueOne() {
        return valueOne;
    }
    public int getValueTwo() {
        return valueTwo;
    }
    public int getResult() {
        return result;
    }
    public OperationsDto(String name, int valueOne, int valueTwo, int result) {
        this.name = name;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.result = result;
    }
}
