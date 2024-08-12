package com.Banking.bank.Controllers;
import com.Banking.bank.Persistence.Models.Person;
import com.Banking.bank.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final PersonService service;
    @Autowired
    public RegisterController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("person") Person person) {
        return "register";
    }
    @PostMapping("/registerAccepted")
    public String registerAccepted(@ModelAttribute("person") Person person) {
        System.out.println(person.toString());
        service.save(person,"Customer");
        return "redirect:/homeRegistered";
    }

    @GetMapping("/homeRegistered")
    public String home(Model model) {
        model.addAttribute("thanks", "Спасибо что доверяете нам!");
        return "home";
    }

}
