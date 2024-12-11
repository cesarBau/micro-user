package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Two;
import com.example.demo.repository.TwoReposi;

@Service
public class TwoService implements ITwoService{

    private static Logger logger = LoggerFactory.getLogger(TwoService.class);

    private final TwoReposi twoReposi;

    public TwoService(TwoReposi twoReposi) {
        this.twoReposi = twoReposi;
    }

    @Override
    public Two createTwo(Two insert) {
        logger.info("Consume service createTwo");
        Two process = twoReposi.save(insert);
        return process;
    }

    @Override
    public Two getTwoById(Integer id) {
        logger.info("Consume service getTwoById");
        try {
            Optional<Two> consume = twoReposi.findById(id);
            return consume.get();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "two not found", e);
        }
    }

    @Override
    public List<Two> getAllTwo() {
        logger.info("Consume service getAllTwo");
        List<Two> process = twoReposi.findAll();
        return process;
    }

    @Override
    public List<Two> getAllByName(String name) {
        logger.info("Consume service getAllByName");
        List<Two> process = twoReposi.findByName(name);
        return process;
    }
}
