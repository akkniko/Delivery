public class Order{

    private int id;
    private String name;
    private double weight;
    private OrderStatus status = OrderStatus.CREATED;
    private double price;

    public Order(int id, String name, double w, double price) {
        this.id = id;
        this.name = name;
        this.weight = w;
        this.price = price;
        // this.status = st;
    }

    public Order(int id, String name, double w, OrderStatus st, double price) {
        this(id, name, w, price); //конструктор верхний с id,name, w 
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