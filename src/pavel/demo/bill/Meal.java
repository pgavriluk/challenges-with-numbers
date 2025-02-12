package pavel.demo.bill;

public class Meal {

    private Hamburger hamburger;
    private Drink drink;
    private Item item;
    private double price;

    public Meal(Hamburger hamburger, Drink drink, Item item) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.item = item;
        this.price = Math.round((hamburger.getBasePrice() + drink.getPrice() + item.getPrice()) * 100.0) / 100.0;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Drink getDrink() {
        return drink;
    }

    public Item getItem() {
        return item;
    }

    public double getPrice() {
        return price + this.getHamburger().getAdditionalPrice();
    }

    @Override
    public String toString() {
        double finalPrice = price + this.getHamburger().getAdditionalPrice();
        return "Meal{" +
                "hamburger=" + hamburger +
                ", drink=" + drink +
                ", sideItem=" + item +
                ", price=" + finalPrice +
                '}';
    }
}
