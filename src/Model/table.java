package Model;

public class table {

    String food_name , unit;
    double amount;
    int calories;

    public  table() {}

    public table(String food_name ,   double amount , String unit  , int calories)
    {
        this.food_name = food_name;
        this.amount = amount;
        this.unit = unit;
        this.calories = calories;
    }

    public  String getFood_name()
    {
        return food_name;
    }

    public String getUnit()
    {
        return unit;
    }

    public double getAmount()
    {
        return amount;
    }

    public  int getCalories()
    {
        return  calories;
    }

}
