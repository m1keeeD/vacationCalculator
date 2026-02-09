package ru.example.vacationcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {
    
private static final double AVG_DAYS_IN_MONTH = 29.3;

public double calculateVP(double avgSalary, int vacationDays){
    double avgDailySalary = avgSalary / AVG_DAYS_IN_MONTH;
    return avgDailySalary * vacationDays;
}

}
