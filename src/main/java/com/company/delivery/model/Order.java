package com.company.delivery.model;

import java.util.Objects;

public class Order{
    private static int count = 1;
    private final int id;
    private final String name;
    private final double weight;
    private OrderStatus status = OrderStatus.CREATED;
    private final double price;

    public Order(String name, double weight, double price) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("name must be not zero!");
        }

        if(weight <= 0 ) {
            throw new IllegalArgumentException("weight must be > 0");
        }

        if(price <= 0 ) {
            throw new IllegalArgumentException("price must be > 0");
        }


        this.id = count++;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Order(String name, double w, OrderStatus st, double price) {
        this(name, w, price); //конструктор верхний с id, name, w
        this.status = st;  
    }

    public double getWeight(){
        return this.weight;
    }

    public  String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }

    OrderStatus getStatus(){
        return this.status;
    }

    public void startDelivery(){
        if(status == OrderStatus.CREATED){
            this.status = OrderStatus.DELIVERING;
        }
        else throw new IllegalStateException("Order can't be Delivering");
    }

    public void completeDelivery(){
        if(status == OrderStatus.DELIVERING){
            this.status = OrderStatus.DELIVERED;
        }
        else{
            throw new IllegalStateException("Order can't be delivered");
        }
    }

    public String toString(){
        return    " id: "       + getId()
                + " name: "     + getName()
                + " price: "    + getPrice()
                + " status: "   + getStatus()
                + " weight: "   + getWeight();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object otherObj){
        if(this == otherObj) return true;
        if(otherObj == null) return false;
        if(this.getClass() != otherObj.getClass()) return false;
        return Objects.equals(getId(), ((Order) otherObj).getId());
    }
}