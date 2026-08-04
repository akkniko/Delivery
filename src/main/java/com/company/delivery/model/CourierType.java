package com.company.delivery.model;

public enum CourierType{
    FOOT(5.0),
    CAR(30.0),
    BICYCLE(10.0),
    BIKE(15.0),
    ROBOT(7.5);
    
    private final double MaxW;

    public double getMaxW(){
        return this.MaxW;
    }

    CourierType(double w){
        this.MaxW = w;
    }

}