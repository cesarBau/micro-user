package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Operations;
import com.example.demo.models.OperationsDto.OperationsDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/calculator")
public class CalController {

    @GetMapping("/hola")
    public String getMethodName(@RequestParam String param) {
        return param;
    }

    @PostMapping("/suma")
    public Map<String, Object> suma(@RequestBody Operations operation) {
        String values = operation.toString();
        int valueA = operation.valueOne();
        int valueB = operation.valueTwo();
        System.out.println(values);
        int process = valueA + valueB;
        OperationsDto createResult = new OperationsDto("Suma",valueA, valueB, process);
        Map<String, Object> body = new HashMap<>();
        body.put("message", createResult);
        return body;
    }

    @PostMapping("/resta")
    public OperationsDto restaController(@RequestBody Operations operation) {
        String values = operation.toString();
        int valueA = operation.valueOne();
        int valueB = operation.valueTwo();
        System.out.println(values);
        int process = valueA - valueB;
        OperationsDto createResult = new OperationsDto("Resta",valueA, valueB, process);
        return createResult;
    }
    
    @PostMapping("/multi")
    public OperationsDto postMethodName(@RequestBody Operations operation) {
        System.out.println(operation.toString());
        int process = operation.valueOne() * operation.valueTwo();
        OperationsDto createResult = new OperationsDto("Multiplicacion",operation.valueOne(), operation.valueTwo(), process);
        return createResult;
    }
    
}
