package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.IPersonService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/v2/person")
public class PersonRelationController {

    @Autowired
    private final IPersonService ipersonService;

    public PersonRelationController(IPersonService ipersonService) {
        this.ipersonService = ipersonService;
    }

    @GetMapping("/")
    public List<Person> getallPerson() {
        return ipersonService.getAllPerson();
    }
    

}
