package ru.example.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.vacationcalculator.service.VacationCalculatorService;


@RestController
public class VacationController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationController(VacationCalculatorService vacationCalculatorService){
        this.vacationCalculatorService = vacationCalculatorService;
    }
    
    @GetMapping("/calculate")
    public double calculate(
        @RequestParam double avgSalary,
        @RequestParam int vacationDays
    ) {
        return vacationCalculatorService.calculateVacationPay(avgSalary, vacationDays);
    }   

}
