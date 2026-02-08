package ru.example.vacationcalculator.model;

public class VacationResponse {
  
    private double vacationPay;

    public VacationResponse(double vacationPay){
        this.vacationPay = vacationPay;
    }

    public double getvacationPay(){
        return vacationPay;
    }

}

