package pavel.demo.bill;

public class Item {

    private String type;
    private double price;

    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
