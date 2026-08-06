package com.company.delivery.model;

import java.util.Objects;

public class Courier{
    private static int count = 1;
    private final int id;
    private final String name;
    private final CourierType type;
    private boolean isBusy;
    private double cash;

    public Courier(String name, CourierType tp) {
        if (name.isEmpty() || name == null){
            throw new IllegalArgumentException("name must be not zero!");
        }

        if (name.getClass() != String.class){
            throw new IllegalArgumentException("name must be string");
        }

        if(tp.getClass() != CourierType.class) {
            throw new IllegalArgumentException("type must belongs to CourierType ");
        }

        if(tp == null) {
            throw new IllegalArgumentException("type must be not zero!");
        }

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

    public void increaseCash(double amount){
        this.cash += amount; 
    }

    public void markFree(){
        if(!this.isBusy){
            throw new IllegalStateException("courier already is free");
        }
        this.isBusy = false;
    };

    public void markBusy(){
        if(this.isBusy){
            throw new IllegalStateException("courier already is busy");
        }
        this.isBusy = true;
    };

    @Override
    public String toString(){
        return "id: "          + getId()
                + " name: "    + getName()
                + " type: "    + getType()
                + " balance: " + getCash();
    };

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object otherObj){
        if(this == otherObj) return true;
        if(otherObj == null) return false;
        if(this.getClass() != otherObj.getClass()) return false;
        return Objects.equals(getId(), ((Courier) otherObj).getId());
    }
}