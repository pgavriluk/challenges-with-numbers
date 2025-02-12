package pavel.demo.bill;

public class Drink {

    private String type;
    private String size;
    private double price;

    public Drink(String type, String size) {
        this.type = type;
        this.size = size;
        if (size.equalsIgnoreCase("small")){
            this.price = 7.00;
        } else if (size.equalsIgnoreCase("medium")){
            this.price = 10;
        } else {
            this.price = 12;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
