package ru.example.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VacationController {
    
    @GetMapping("/calculate")
    public String calculate() {
        return "Vacation calculator is working";
    }   

}
