package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Nombre;
import com.example.demo.repository.NombreRepository;

@Service
public class NombreService implements INombreService {

    private static Logger logger = LoggerFactory.getLogger(NombreService.class);

    private final NombreRepository nombreRepository;

    public NombreService(NombreRepository nombreRepository) {
        this.nombreRepository = nombreRepository;
    }

    @Override
    public Nombre createNombre(Nombre nombre) {
        logger.info("Consume service createNombre");
        return nombreRepository.save(nombre);
    }

    @Override
    public Nombre getNombreById(Integer id) {
        logger.info("Consume service createNombre");
        try {
            Optional<Nombre> consult = nombreRepository.findById(id);
            return consult.get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name not found", e);
        }
    }

    @Override
    public List<Nombre> getNombreByNombre(String nombre) {
        logger.info("Consume service getNombreByNombre");
        List<Nombre> consult = nombreRepository.getByNombre(nombre);
        if (!consult.isEmpty()) {
            return consult;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name not found", null);
        }
    }

    @Override
    public void deleteNombre(Integer id) {
        logger.info("Consume service deleteNombre");
        logger.info("Search nombre");
        try {
            Optional<Nombre> consult = nombreRepository.findById(id);
            nombreRepository.deleteById(consult.get().getId());
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name not found", e);
        }
    }

    @SuppressWarnings("unused")
    @Override
    public Nombre updateNombre(Integer id, Nombre nombre) {
        logger.info("Consume service updateNombre");
        Nombre process = nombreRepository.getReferenceById(id);
        if (process != null) {
            process.setNombre(nombre.getNombre());
            process.setSegundoNombre(nombre.getSegundoNombre());
            Nombre result = nombreRepository.save(process);
            return result;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name not found", null);
        }
    }

}
