package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.EstatusSuscripcion;
import com.example.demo.entity.Suscripcion;
import com.example.demo.repository.SuscripcionRepository;

@Service
public class SuscripcionService implements ISuscripcionService {

    private static Logger logger = LoggerFactory.getLogger(SuscripcionService.class);

    private final SuscripcionRepository suscripcionRepository;

    public SuscripcionService(SuscripcionRepository suscripcionRepository) {
        this.suscripcionRepository = suscripcionRepository;
    }

    @Override
    public Suscripcion createSuscription(Suscripcion suscripcion) {
        try {
            return suscripcionRepository.save(suscripcion);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "idproveedor not relation in users", e);
        }
        
    }

    @Override
    public Suscripcion getSuscriptionById(Integer id) {
        logger.info("Consume service getSuscriptionById");
        try {
            Optional<Suscripcion> consult = suscripcionRepository.findById(id);
            Suscripcion result = consult.get();
            logger.info(result.toString());
            return result;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "User not found", e);
        }
    }

    @Override
    public Suscripcion getSuscripcionForIdproveedor(String idproveedor) {
        logger.info("Consume service getSuscripcionForIdproveedor");
        Suscripcion result = suscripcionRepository.findByIdproveedor(idproveedor);
        if(result != null){
            return result;
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found", null);
        }
        
    }

    @Override
    public Suscripcion cancelSuscription(String idproveedor) {
        LocalDateTime now = LocalDateTime.now();
        Suscripcion consult = suscripcionRepository.findByIdproveedor(idproveedor);
        EstatusSuscripcion cancel = new EstatusSuscripcion(2,"cancelado");
        consult.setFechaCancelacion(now);
        consult.setUpdate(now);
        consult.setFechaActivacion(null);
        consult.setEstatusSuscripcion(cancel);
        suscripcionRepository.save(consult);
        return consult;
    }

    @Override
    public Suscripcion updateSuscripcioon(String idproveedor) {
        LocalDateTime now = LocalDateTime.now();
        Suscripcion consult = suscripcionRepository.findByIdproveedor(idproveedor);
        EstatusSuscripcion activated = new EstatusSuscripcion(1,"activo");
        consult.setEstatusSuscripcion(activated);
        consult.setUpdate(now);
        consult.setFechaActivacion(now);
        consult.setFechaCancelacion(null);
        return suscripcionRepository.save(consult);
    }
}
