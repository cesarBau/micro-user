package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Apellido> getApellidoByApellido(String apellido) {
        logger.info("Consume service getApellidoByApellido");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Apellido getApellidoById(Integer id) {
        logger.info("Consume service getApellidoById");
        return apellidoRepository.getReferenceById(id);
    }

}
