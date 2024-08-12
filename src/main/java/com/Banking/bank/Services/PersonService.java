package com.Banking.bank.Services;

import com.Banking.bank.Persistence.Models.Person;
import com.Banking.bank.Persistence.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person save(Person person,String Role) {
        String password=passwordEncoder.encode(person.getPassword());
        String UserName=person.getName();
        String email=person.getEmail();
        String phone=person.getPhone();

        return personRepository.save(new Person(UserName,phone,email,Role,password));
    }
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    public Optional<Person> findByName(String name) {
        return personRepository.findByName(name);
    }


}
