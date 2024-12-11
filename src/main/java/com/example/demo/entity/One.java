package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class One {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nameOne;
    @OneToMany(targetEntity = Two.class, mappedBy = "one", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Two> twos = new ArrayList<>();
    
    public One(Integer id, String nameOne, List<Two> twos) {
        this.id = id;
        this.nameOne = nameOne;
        this.twos = twos;
    }

    public One() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public List<Two> getTwos() {
        return twos;
    }

    public void setTwos(List<Two> twos) {
        this.twos = twos;
    }
    
}
