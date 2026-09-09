package org.company.delivery.model;

public enum CourierType{
    FOOT(5.0),
    CAR(30.0),
    BICYCLE(10.0),
    BIKE(15.0),
    ROBOT(7.5);
    
    private final double maxWeight;

    public double getMaxWeight(){
        return this.maxWeight;
    }

    CourierType(double w){
        this.maxWeight = w;
    }

}