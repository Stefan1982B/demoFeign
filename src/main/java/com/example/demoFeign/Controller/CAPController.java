package com.example.demoFeign.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CAPController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

