package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.entity.One;
import com.example.demo.repository.OneRepository;

@Service
public class OneService implements IOneService{

    private static Logger logger = LoggerFactory.getLogger(OneService.class);
    
    private final OneRepository oneRepository;

    public OneService(OneRepository oneRepository) {
        this.oneRepository = oneRepository;
    }

    @Override
    public One getOnesById(Integer id) {
        logger.info("Consume service getOnesById");
        One result = oneRepository.getReferenceById(id);
        logger.info(result.toString());
        return result;
    }

    @Override
    public One createOne(One one) {
        logger.info("Consume service createOne");
        //LocalDateTime now = LocalDateTime.now();
        One result = oneRepository.save(one);
        return result;
    }

    

}
