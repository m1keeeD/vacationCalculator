package ru.example.vacationcalculator.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.example.vacationcalculator.model.VacationRequest;
import ru.example.vacationcalculator.service.VacationCalculatorService;

@Controller
public class VacationPageController {
    
    private  final VacationCalculatorService service;

    public VacationPageController(VacationCalculatorService service){
        this.service = service;
    }

    @GetMapping("/")
    public String showForm(Model model){

        model.addAttribute("vacationRequest", new VacationRequest());
        return "vacation-form";

    }

    @PostMapping("/calculate")
    public String calculate(
        @Valid @ModelAttribute VacationRequest vacationRequest,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()){
            return "vacation-form";
        }

        double vacationPay = service.calculateVP(
            vacationRequest.getAvgSalary(),
            vacationRequest.getVacationDays()
        );

        model.addAttribute("vacationPay", vacationPay);
        model.addAttribute("vacationRequest", vacationRequest);

        return "vacation-result";
    }

}
