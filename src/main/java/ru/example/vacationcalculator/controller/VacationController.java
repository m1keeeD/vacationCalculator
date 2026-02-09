package ru.example.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.vacationcalculator.service.VacationCalculatorService;
import ru.example.vacationcalculator.model.VacationResponse;


@RestController
@RequestMapping("/api/vacation")
public class VacationController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationController(VacationCalculatorService vacationCalculatorService){
        this.vacationCalculatorService = vacationCalculatorService;
    }
    
    @GetMapping("/calculate")
    public VacationResponse calculate(
        @RequestParam double avgSalary,
        @RequestParam int vacationDays
    ) {
        if (avgSalary <= 0){
            throw new IllegalArgumentException("Avg. salary must be over 0");
        }
        if (vacationDays <= 0){
            throw new IllegalArgumentException("Vacation days can't be less or equal to 0");
        }

        double result = vacationCalculatorService.calculateVP(avgSalary, vacationDays);
        double roundedResult = Math.round(result*100)/100.0;
        return new VacationResponse(roundedResult);
    }   

}

