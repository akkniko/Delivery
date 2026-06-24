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

    String GetName(){
        return this.name;
    }

    int GetId(){
        return this.id;
    }

    boolean isBusy(){
        return this.isBusy;
    }

    double GetCash(){
        return this.cash;
    }

    CourierType GetType(){
        return this.type;
    }

    void SetIsBusy(boolean b){
        this.isBusy = b;
    }

    void IncreaseCash(double amount){
        this.cash += amount; 
    }

    void ChangeBStatus(){
       this.isBusy = !this.isBusy;
    }
}