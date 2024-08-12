package com.Banking.bank.config;

import com.Banking.bank.Persistence.Models.Person;
import com.Banking.bank.Persistence.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user=personRepository.findByName(username);


        return user.map(PersonDetails::new).orElseThrow(()->new UsernameNotFoundException(username+" not found"));
    }
}
