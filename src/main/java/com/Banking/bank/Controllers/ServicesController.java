package com.Banking.bank.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ServicesController {


    @GetMapping("/services")
    public String services(){
        return "services";
    }
}
