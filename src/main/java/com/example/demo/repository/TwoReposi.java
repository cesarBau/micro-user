package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Two;

public interface TwoReposi extends JpaRepository<Two, Integer>{

    List<Two> findByName(String name);

}
