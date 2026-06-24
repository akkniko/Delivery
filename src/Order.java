public class Order{

    private int id;
    private String name;
    private double weight;
    private OrderStatus status = OrderStatus.CREATED;

    public Order(int id, String name, double w) {
        this.id = id;
        this.name = name;
        this.weight = w;
        // this.status = st;
    }

    public Order(int id, String name, double w, OrderStatus st) {
        this(id, name, w); //конструктор верхний с id,name, w 
        this.status = st;  
    }

    void SetStatus(OrderStatus st){
        this.status = st;
        System.out.println("Setter was activated, status has been changed");
    }

    double GetWeight(){
        return this.weight;
    }

    String GetName(){
        return this.name;
    }

    int GetId(){
        return this.id;
    }

    OrderStatus GetStatus(){
        return this.status;
    }

}