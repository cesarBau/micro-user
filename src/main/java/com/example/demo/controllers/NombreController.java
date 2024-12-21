package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Apellido;
import com.example.demo.entity.Nombre;
import com.example.demo.model.NombreModel;
import com.example.demo.model.dto.NombreDto;
import com.example.demo.model.dto.ObjApellidoDto;
import com.example.demo.service.INombreService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/name")
public class NombreController {

    private static Logger logger = LoggerFactory.getLogger(NombreController.class);

    @Autowired
    private final INombreService iNombreService;

    public NombreController(INombreService iNombreService) {
        this.iNombreService = iNombreService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NombreDto getNombre(@PathVariable Integer id) {
        logger.info("Consume controller getNombre");
        List<ObjApellidoDto> apellido = new ArrayList<>();
        Nombre consult = iNombreService.getNombreById(id);
        for (Apellido nombre : consult.getApellido()) {
            apellido.add(new ObjApellidoDto(nombre.getId(), nombre.getApellido(), nombre.getSegundoApellido()));
        }
        NombreDto response = new NombreDto(consult.getId(),
                consult.getNombre(),
                consult.getSegundoNombre(),
                consult.getUsuario(),
                apellido);
        return response;
    }

    @GetMapping("/name/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NombreDto> getByNombre(@PathVariable String nombre) {
        logger.info("Consume controller getNombre");
        List<NombreDto> response = new ArrayList<>();
        List<Nombre> searchregistries = iNombreService.getNombreByNombre(nombre);
        if (searchregistries != null) {
            for (Nombre consult : searchregistries) {
                List<ObjApellidoDto> apellido = new ArrayList<>();
                for (Apellido search : consult.getApellido()) {
                    apellido.add(new ObjApellidoDto(search.getId(), search.getApellido(), search.getSegundoApellido()));
                }
                response.add(new NombreDto(consult.getId(),
                        consult.getNombre(),
                        consult.getSegundoNombre(),
                        consult.getUsuario(),
                        apellido));
            }
        }
        return response;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public NombreDto createNombre(@RequestBody NombreModel entity) {
        logger.info("Consume controller createNombre");
        List<ObjApellidoDto> apellido = new ArrayList<>();
        Nombre name = new Nombre();
        name.setNombre(entity.getNombre());
        name.setSegundoNombre(entity.getSegundoNombre());
        name.setUsuario(entity.getUsuarioId());
        Nombre create = iNombreService.createNombre(name);
        if (create.getApellido() != null) {
            for (Apellido nombre : create.getApellido()) {
                apellido.add(new ObjApellidoDto(nombre.getId(), nombre.getApellido(), nombre.getSegundoApellido()));
            }
        }
        NombreDto response = new NombreDto(create.getId(),
                create.getNombre(),
                create.getSegundoNombre(),
                create.getUsuario(),
                apellido);
        return response;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public NombreDto updateNombre(@RequestBody NombreModel entity, @PathVariable Integer id) {
        logger.info("Consume controller updateNombre");
        List<ObjApellidoDto> apellido = new ArrayList<>();
        Nombre name = new Nombre();
        name.setId(id);
        name.setNombre(entity.getNombre());
        name.setSegundoNombre(entity.getSegundoNombre());
        name.setUsuario(entity.getUsuarioId());
        Nombre create = iNombreService.updateNombre(id, name);
        if (create.getApellido() != null) {
            for (Apellido nombre : create.getApellido()) {
                apellido.add(new ObjApellidoDto(nombre.getId(), nombre.getApellido(), nombre.getSegundoApellido()));
            }
        }
        NombreDto response = new NombreDto(create.getId(),
                create.getNombre(),
                create.getSegundoNombre(),
                create.getUsuario(),
                apellido);
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteNombre(@PathVariable Integer id) {
        logger.info("Consume controller deleteNombre");
        iNombreService.deleteNombre(id);
    }
}
