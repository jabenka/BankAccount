package com.Banking.bank.Persistence.Repositories;

import com.Banking.bank.Persistence.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Optional<Person> findByName(String firstName);
}