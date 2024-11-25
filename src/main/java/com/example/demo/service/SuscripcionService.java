package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public Suscripcion getSuscriptionById(Integer id) {
        logger.info("Consume service getSuscriptionById");
        Optional<Suscripcion> consult = suscripcionRepository.findById(id);
        Suscripcion result = consult.get();
        logger.info(result.toString());
        return result;
    }

    @Override
    public Suscripcion getSuscripcionForIdproveedor(String idproveedor) {
        logger.info("Consume service getSuscripcionForIdproveedor");
        Suscripcion result = suscripcionRepository.findByIdproveedor(idproveedor);
        return result;
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
