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

import com.example.demo.entity.One;
import com.example.demo.entity.Two;
import com.example.demo.models.OperationsDto.OneDto;
import com.example.demo.models.OperationsDto.TwoObjtDto;
import com.example.demo.service.IOneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/one")
public class OneController {

    private static Logger logger = LoggerFactory.getLogger(OneController.class);

    @Autowired
    private final IOneService iOneService;

    public OneController(IOneService iOneService) {
        this.iOneService = iOneService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public OneDto getOne(@PathVariable Integer id) {
        logger.info("Consume controller getOne");
        logger.info(Integer.toString(id));
        One response = iOneService.getOnesById(id);
        List<TwoObjtDto> bodyTwo= new ArrayList<>();
        for (Two two : response.getTwos()) {
            bodyTwo.add(new TwoObjtDto(two.getId(), two.getName()));
        }
        OneDto createresponse = new OneDto(id, response.getNameOne(), bodyTwo);
        logger.info(createresponse.toString());
        return createresponse;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public One createOne(@RequestBody One entity) {
        logger.info("Consume controller getOne");
        logger.info(entity.toString());
        return iOneService.createOne(entity);
    }
    
    

}
