package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface IPersonService {

    Person savePerson(Person person);
    void deletePerson(Long id);
    List<Person> getAllPerson();
    void updateNamePerson(String name, Long id);
    void updatePerson(Person person, Long id);
    Person getPersonById(Long id);
}
