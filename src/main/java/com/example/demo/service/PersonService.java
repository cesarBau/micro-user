package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService implements IPersonService{

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void updateNamePerson(String name, Long id){
        Optional<Person> process = personRepository.findById(id);
        Person update =  process.get();
        update.setName(name);
        personRepository.save(update);
    }

    @Override
    public void updatePerson(Person person, Long id) {
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> process = personRepository.findById(id);
        Person result =  process.get();
        return result;
    }
}
