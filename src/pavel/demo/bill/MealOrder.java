package pavel.demo.bill;

import java.util.ArrayList;
import java.util.List;

public class MealOrder {

    private List<Meal> meals = new ArrayList<>();
    private double totalPrice;

    public MealOrder() {
        Hamburger hamburger = new Hamburger("Regular Burger", 10);
        Drink drink = new Drink("Coke", "Small");
        Item item = new Item("Fries", 5.00);
        Meal meal = new Meal(hamburger, drink, item);
        this.meals.add(meal);
        this.totalPrice += meal.getPrice();
    }

    public MealOrder(Meal meal) {
        this.meals.add(meal);
        this.totalPrice += meal.getPrice();
    }

    public MealOrder add(Meal meal){
        this.meals.add(meal);
        this.totalPrice += meal.getPrice();
        return this;
    }

    @Override
    public String toString() {
        return "MealOrder{" +
                "meals=" + meals +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
