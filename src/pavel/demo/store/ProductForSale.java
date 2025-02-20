package pavel.demo.store;

public abstract class ProductForSale {

    private final String type;
    private final double price;
    private final String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getSalesPrice(int quantity){
        return quantity * this.price;
    }

    public void printPricedItem(int quantity){
        System.out.printf("%2d quantity at $%8.2f each, %-15s %-35s %n", quantity, this.price, this.type, description);
    }

    public abstract void showDetails();
}
