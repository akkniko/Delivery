import java.util.ArrayList;

public class DeliveryService{
    private ArrayList<Courier> couriers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
/*
Метод регистрации курьера: принимает объект курьера и добавляет его в общий список.

Метод создания заказа: принимает вес и стоимость, создает объект заказа, добавляет в список заказов. Сразу после этого запускает внутренний метод поиска курьера.

Метод назначения курьера: перебирает список курьеров. Ищет того, кто: а) свободен, б) его CourierType позволяет поднять вес этого заказа (проверка лимитов 5 кг или 30 кг). Если нашли — меняем статус заказа на DELIVERING, курьера делаем занятым. Если не нашли — выводим сообщение «Нет подходящих курьеров».

Метод завершения доставки: принимает ID заказа. Находит этот заказ, меняет статус на DELIVERING -> DELIVERED. Находит курьера, который его вез, начисляет ему на баланс, например, 10% от стоимости заказа, и переводит курьера в статус «свободен».
*/
    
    void curRegistration(Courier cr){
        if(couriers.contains(cr)){
            System.out.println("this courier is already in list");
        }
        else{
            couriers.add(cr);
        }
    }

    Courier findCourier(Order o){
        for(Courier c : couriers){
            if(o.getWeight() <= c.getType().getMaxW() && !c.isBusy()){
                curRegistration(c);
                o.setStatus(OrderStatus.DELIVERING);
                return c;
            }
        }
        return null;
    }

    void makeOrder(double price, double w, int id, String name){
        Order o = new Order(id, name, w,price);
        if(!orders.contains(o)){
            orders.add(o);
            findCourier(o);
            o.setStatus(OrderStatus.CREATED);
        }
        else{
            System.out.println("This order is already exist! ");
        }
    }

    void destinDelivery(int id){
        //todo: exceptions
        Courier c;
        for(Order o: orders){
            if(id == o.getId()){
                o.setStatus(OrderStatus.DELIVERED);
                System.out.println("The order has been delivered");
                c = findCourier(o);
                c.setIsBusy(false);
                c.increaseCash(o.getPrice()/10);
            }
        }
    }
}