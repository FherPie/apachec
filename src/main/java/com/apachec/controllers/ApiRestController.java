package com.apachec.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class ApiRestController {

    @GetMapping("/proveer")
    public String proveer(){
        return "Helllo";
    }
}
