package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Apellido;
import com.example.demo.model.dto.ApellidoDto;
import com.example.demo.service.IApellidoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/lastname")
public class ApellidoController {

    private static Logger logger = LoggerFactory.getLogger(ApellidoController.class);

    private final IApellidoService iApellidoService;

    public ApellidoController(IApellidoService iApellidoService) {
        this.iApellidoService = iApellidoService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApellidoDto getApellidoById(@PathVariable Integer id) {
        logger.info("Consume controller getApellidoById");
        Apellido consult = iApellidoService.getApellidoById(id);
        ApellidoDto response = new ApellidoDto(consult.getId(), consult.getApellido(), consult.getSegundoApellido(),
                consult.getNombre().getId());
        return response;
    }

    @GetMapping("/lastname/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ApellidoDto> getByApellido(@PathVariable String name) {
        logger.info("Consume controller getByApellido");
        List<ApellidoDto> response = new ArrayList<>();
        List<Apellido> consult = iApellidoService.getApellidoByApellido(name);
        for (Apellido apellido : consult) {
            response.add(new ApellidoDto(apellido.getId(), apellido.getApellido(), apellido.getSegundoApellido(),
                    apellido.getNombre().getId()));
        }
        return response;
    }

}
