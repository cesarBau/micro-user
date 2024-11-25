package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.StatusEntity;

public interface StatusRepository extends CrudRepository<StatusEntity, Long> {

}
