package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.models.OperationsDto.PersonDto;
import com.example.demo.service.IPersonService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final IPersonService ipersonService;

    public PersonController(IPersonService ipersonService) {
        this.ipersonService = ipersonService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PersonDto responsePerson(@RequestBody Person person) {
        Person operation = ipersonService.savePerson(person);
        PersonDto result = new PersonDto(operation.getId(), operation.getName(), operation.getEmail());
        return result;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PersonDto> getPersons() {
        List<PersonDto> process = new ArrayList<>();
        List<Person> info = ipersonService.getAllPerson();
        for (Person person : info) {
            process.add(new PersonDto(person.getId(), person.getName(), person.getEmail()));
        }
        return process;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updatePerson(@PathVariable Long id, @RequestBody Person person) {
        ipersonService.updatePerson(person, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateNamePerson(@PathVariable Long id, @RequestBody Person person){
        ipersonService.updateNamePerson(person.getName(), id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PersonDto getPersonById(@PathVariable Long id) {
        Person operation = ipersonService.getPersonById(id);
        PersonDto result = new PersonDto(operation.getId(), operation.getName(), operation.getEmail());
        return result;
    }

}
