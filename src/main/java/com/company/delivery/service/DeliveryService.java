package com.company.delivery.service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.company.delivery.model.Courier;
import com.company.delivery.model.Order;
import com.company.delivery.model.OrderStatus;


public class DeliveryService{
    private final List<Courier> couriers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final Map<Integer, Courier> assignedCourier = new HashMap<>();

/*
Метод регистрации курьера: принимает объект курьера и добавляет его в общий список.
Метод создания заказа: принимает вес и стоимость, создает объект заказа, добавляет в список заказов. Сразу после этого запускает внутренний метод поиска курьера.
Метод назначения курьера: перебирает список курьеров. Ищет того, кто: а) свободен, б) его CourierType позволяет поднять вес этого заказа (проверка лимитов 5 кг или 30 кг). Если нашли — меняем статус заказа на DELIVERING, курьера делаем занятым. Если не нашли — выводим сообщение «Нет подходящих курьеров».
Метод завершения доставки: принимает ID заказа. Находит этот заказ, меняет статус на DELIVERING -> DELIVERED. Находит курьера, который его вез, начисляет ему на баланс, например, 10% от стоимости заказа, и переводит курьера в статус «свободен».
*/

    public void registerCourier(Courier cr){
        if(couriers.contains(cr)){
            System.out.println("this courier is already in list");
        }
        else{
            couriers.add(cr);
            System.out.println("Courier " + cr.getName() + " was registered");
        }
    }

    public Optional<Courier> findCourier(Order o){
        //todo: search with stream api
        return couriers.stream()
                .filter(t-> o.getWeight() <= t.getType().getMaxW() && !t.isBusy())
                .findFirst();
    }

    public Order createOrder(double price, double w, String name) {
        Order o = new Order(name, w, price);
        if(!orders.contains(o)) orders.add(o);

        Optional<Courier> c = findCourier(o);

            c.ifPresentOrElse(
                    t -> {
                        t.markBusy();
                        o.setStatus(OrderStatus.DELIVERING);
                        assignedCourier.put(o.getId(), t);
                        System.out.println("order " + o.getName() + "  delivering! ");
                    },
                    () -> {
                        o.setStatus(OrderStatus.CREATED);
                        System.out.println("order " + o.getName() + "  created! ");
                    }
            );

        return o;
    }

    public void completeDelivery(int id) {
        //todo: exceptions, stream api
        orders.stream().
                filter(t -> t.getId() == id)
                .findFirst()
                .ifPresent(c ->
                        {
                    c.setStatus(OrderStatus.DELIVERED);
                    System.out.println("Order " + c.getName() + " id: " + c.getId() + " delivered");

                    Courier k = assignedCourier.get(c.getId());
                    if(k != null) {
                        k.markFree();
                        k.increaseCash(c.getPrice() / 10);
                    }
                    else{
                        System.out.println("The order hadn't had an assigned courier\n");
                        }
                    });
    }
}
