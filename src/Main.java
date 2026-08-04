public class Main{
    public static void main(String [] args){
        Courier c1 = new Courier( "bob", CourierType.CAR);
        Courier c2 = new Courier( "chak", CourierType.FOOT);
        Courier c3 = new Courier( "GPT", CourierType.ROBOT);
        Courier c4 = new Courier( "XPYCT", CourierType.BIKE);

        DeliveryService ds = new DeliveryService();
        
        ds.curRegistration(c1);
        ds.curRegistration(c2);
        ds.curRegistration(c3);
        ds.curRegistration(c4);
        
        Order o = ds.makeOrder(100, 10, 1, "bk");
        ds.destinDelivery(o.getId());



    }
}