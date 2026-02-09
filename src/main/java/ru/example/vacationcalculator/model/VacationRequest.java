package ru.example.vacationcalculator.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VacationRequest {

    @NotNull(message = "Average salary is required")
    @Positive(message = "Average salary must be greater than 0")
    private Double avgSalary;

    @NotNull(message = "Vacation days is required")
    @Positive(message = "Vacation days must be greater than 0")
    private Integer vacationDays;

    public Double getAvgSalary(){
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary){
        this.avgSalary = avgSalary;
    }

    public Integer getVacationDays(){
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays){
        this.vacationDays = vacationDays;
    }
}
