import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DeliveryService{
    private final List<Courier> couriers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final HashMap<Integer, Courier> map = new HashMap<>();

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
            System.out.println("Courier " + cr.getName() + " was registered");
        }
    }

    Optional<Courier> findCourier(Order o){
        //todo: search with stream api
        return couriers.stream()
                .filter(t-> o.getWeight() <= t.getType().getMaxW() && !t.isBusy())
                .findFirst();
    }

    Order makeOrder(double price, double w, String name) {
        Order o = new Order(name, w, price);
        Optional<Courier> c = findCourier(o);

            c.ifPresentOrElse(
                    t -> {
                        t.setIsBusy(true);
                        o.setStatus(OrderStatus.DELIVERING);
                        map.put(o.getId(), t);
                        System.out.println("order " + o.getName() + "  delivering! ");
                    },
                    () -> {
                        o.setStatus(OrderStatus.CREATED);
                        System.out.println("order " + o.getName() + "  created! ");
                    }
            );

        return o;
    }

    void destinDelivery(int id){
        //todo: exceptions, stream api
        for(Order o : orders){
            if(id == o.getId()){
                o.setStatus(OrderStatus.DELIVERED);
                System.out.println("Order " + o.getName() + " has been delivered");
                
                Courier c = map.get(o.getId());
                if(c != null){
                    c.changeBStatus();
                    c.increaseCash(o.getPrice()/10);
                }
                else{
                    System.out.println("The order hadn't had an assigned courier ");
                }
                break;
            }
        }
    }
}
