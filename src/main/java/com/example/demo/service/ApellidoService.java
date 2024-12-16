package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Apellido;
import com.example.demo.repository.ApellidoRepository;

@Service
public class ApellidoService implements IApellidoService {

    private static Logger logger = LoggerFactory.getLogger(ApellidoService.class);

    private final ApellidoRepository apellidoRepository;

    public ApellidoService(ApellidoRepository apellidoRepository) {
        this.apellidoRepository = apellidoRepository;
    }

    @Override
    public Apellido creatApellido(Apellido apellido) {
        logger.info("Consume service creatApellido");
        return apellidoRepository.save(apellido);
    }

    @Override
    public List<Apellido> getApellidoByApellido(String apellido) {
        logger.info("Consume service getApellidoByApellido");
        List<Apellido> consult = apellidoRepository.getByApellido(apellido);
        if (!consult.isEmpty()) {
            return consult;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "lastname not found", null);
        }
    }

    @Override
    public Apellido getApellidoById(Integer id) {
        logger.info("Consume service getApellidoById");
        try {
            Optional<Apellido> consult = apellidoRepository.findById(id);
            return consult.get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "lastname not found", e);
        }
    }

}
