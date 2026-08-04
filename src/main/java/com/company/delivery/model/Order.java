package com.company.delivery.model;

import com.company.delivery.model.OrderStatus;

public class Order{
    private static int count = 1;
    private final int id;
    private final String name;
    private final double weight;
    private OrderStatus status = OrderStatus.CREATED;
    private final double price;

    public Order(String name, double w, double price) {
        this.id = count++;
        this.name = name;
        this.weight = w;
        this.price = price;
    }

    public Order(String name, double w, OrderStatus st, double price) {
        this(name, w, price); //конструктор верхний с id, name, w
        this.status = st;  
    }

    public void setStatus(OrderStatus st){
        this.status = st;
        System.out.println("Setter was activated, status has been changed");
    }

    public double getWeight(){
        return this.weight;
    }

    public   String getName(){
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

}