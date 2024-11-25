package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EstatusSuscripcion;
import com.example.demo.repository.EstatusSuscrpcionRepository;

@Service
public class EstatusSuscripcionService implements IEstatusSuscripcion {

    private EstatusSuscrpcionRepository estatusSuscrpcionRepository;

    public EstatusSuscripcionService(EstatusSuscrpcionRepository estatusSuscrpcionRepository) {
        this.estatusSuscrpcionRepository = estatusSuscrpcionRepository;
    }

    @Override
    public EstatusSuscripcion getById(Integer id) {
        Optional<EstatusSuscripcion> consult = estatusSuscrpcionRepository.findById(id);
        EstatusSuscripcion result = consult.get();
        return result;
    }



}
