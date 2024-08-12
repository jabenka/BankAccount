package com.Banking.bank.Controllers;

import com.Banking.bank.Persistence.Models.Person;
import com.Banking.bank.Persistence.Repositories.PersonRepository;
import com.Banking.bank.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonAreaController {
    @Autowired
    private PersonService service;
    @GetMapping("/loginProcess")
    public String login(@ModelAttribute("person") Person person) {
        return "PersonalArea";
    }
    @PostMapping("/loginAccepted")
    public String accepted(@ModelAttribute("person") Person person) {
        if(service.findByName(person.getName()).isPresent()){
            return "PersonalAreaConfirmed";
        }else{
            return "PersonalArea";
        }
    }
}
