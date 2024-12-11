package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Two;
import com.example.demo.models.OperationsDto.TwoDto;
import com.example.demo.service.ITwoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/two")
public class TwoController {

    private static Logger logger = LoggerFactory.getLogger(TwoController.class);

    @Autowired
    public final ITwoService iTwoService;

    public TwoController(ITwoService iTwoService) {
        this.iTwoService = iTwoService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TwoDto getTwoById(@PathVariable Integer id) {
        logger.info("Consume controller getTwoById");
        Two consult = iTwoService.getTwoById(id);
        List<Two> bodyTwo = new ArrayList<>();
        bodyTwo.add(consult);
        TwoDto response =new TwoDto("sucess", bodyTwo);
        return response;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TwoDto getAllTwo() {
        logger.info("Consume controller getAllTwo");
        List<Two> bodyTwo = iTwoService.getAllTwo();
        TwoDto response =new TwoDto("sucess", bodyTwo);
        return response;
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TwoDto getTwoByName(@PathVariable String name) {
        logger.info("Consume controller getTwoByName");
        List<Two> bodyTwo = iTwoService.getAllByName(name);
        TwoDto response =new TwoDto("sucess", bodyTwo);
        return response;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TwoDto createTwo(@RequestBody Two entity) {
        logger.info("Consume controller createTwo");
        Two create = iTwoService.createTwo(entity);
        List<Two> bodyTwo = new ArrayList<>();
        bodyTwo.add(create);
        TwoDto response =new TwoDto("sucess", bodyTwo);
        return response;
    }
    
    
}
