public class Order{
    private static int count = 1;
    private final int id;
    private String name;
    private double weight;
    private OrderStatus status = OrderStatus.CREATED;
    private double price;

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

    void setStatus(OrderStatus st){
        this.status = st;
        System.out.println("Setter was activated, status has been changed");
    }

    double getWeight(){
        return this.weight;
    }

    String getName(){
        return this.name;
    }

    int getId(){
        return this.id;
    }

    double getPrice(){
        return this.price;
    }

    OrderStatus getStatus(){
        return this.status;
    }

}