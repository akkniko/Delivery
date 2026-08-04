package com.company.delivery.model;

public class Courier{
    private static int count = 1;
    private final int id;
    private final String name;
    private final CourierType type;
    private boolean isBusy;
    private double cash;

    public Courier(String name, CourierType tp){
        this.id = count++;
        this.name= name;
        this.type = tp;
        this.isBusy = false;
        this.cash = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public boolean isBusy(){
        return this.isBusy;
    }

    public double getCash(){
        return this.cash;
    }

    public  CourierType getType(){
        return this.type;
    }

    public  void setIsBusy(boolean b){
        this.isBusy = b;
    }

    public void increaseCash(double amount){
        this.cash += amount; 
    }

    public void changeBStatus(){
       this.isBusy = !this.isBusy;
    }
}