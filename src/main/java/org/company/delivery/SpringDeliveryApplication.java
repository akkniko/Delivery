package org.company.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.company.delivery.model.Courier;
import org.company.delivery.model.Order;
import org.company.delivery.model.CourierType;
import org.company.delivery.service.DeliveryService;

@SpringBootApplication
public class SpringDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeliveryApplication.class, args);
        Courier c1 = new Courier("bob", CourierType.CAR);
        Courier c2 = new Courier("chak", CourierType.FOOT);
        Courier c3 = new Courier("GPT", CourierType.ROBOT);
        Courier c4 = new Courier("XPYCT", CourierType.BIKE);

        DeliveryService ds = new DeliveryService();

        ds.registerCourier(c1);
        ds.registerCourier(c2);
        ds.registerCourier(c3);
        ds.registerCourier(c4);

        Order o = ds.createOrder(100, 10, "bk");
        ds.completeDelivery(o.getId());
        System.out.println(o);
    }
}
