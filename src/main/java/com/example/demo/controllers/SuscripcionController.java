package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Suscripcion;
import com.example.demo.service.ISuscripcionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/suscription")
public class SuscripcionController {

    private static Logger logger = LoggerFactory.getLogger(SuscripcionController.class);

    @Autowired
    private final ISuscripcionService isuscripcionService;

    public SuscripcionController(ISuscripcionService isuscripcionService) {
        this.isuscripcionService = isuscripcionService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Suscripcion getSuscriptionByIdproveedor(@PathVariable String id) {
        logger.info("Consume controller getSuscriptionByIdproveedor");
        return isuscripcionService.getSuscripcionForIdproveedor(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Suscripcion createSuscription(@RequestBody Suscripcion suscripcion) {
        logger.info("Consume controller createSuscription");
        return isuscripcionService.createSuscription(suscripcion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Suscripcion cancelSuscription(@PathVariable String id){
        logger.info("Consume controller cancelSuscription");
        return isuscripcionService.cancelSuscription(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Suscripcion updateSuscription(@PathVariable String id){
        logger.info("Consume controller updateSuscription");
        return isuscripcionService.updateSuscripcioon(id);
    }

}
