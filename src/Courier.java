public class Courier{
    private int id;
    private String name;
    private CourierType type; 
    private boolean isBusy;
    private double cash;

    public Courier(int id, String name, CourierType tp){
        this.id = id;
        this.name= name;
        this.type = tp;
        this.isBusy = false;
        this.cash = 0;
    }

    String getName(){
        return this.name;
    }

    int getId(){
        return this.id;
    }

    boolean isBusy(){
        return this.isBusy;
    }

    double getCash(){
        return this.cash;
    }

    CourierType getType(){
        return this.type;
    }

    void setIsBusy(boolean b){
        this.isBusy = b;
    }

    void increaseCash(double amount){
        this.cash += amount; 
    }

    void changeBStatus(){
       this.isBusy = !this.isBusy;
    }
}