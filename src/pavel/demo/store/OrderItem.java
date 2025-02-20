package pavel.demo.store;

public class OrderItem {

    private int quantity;
    private final ProductForSale productForSale;

    public OrderItem(int quantity, ProductForSale productForSale) {
        this.quantity = quantity;
        this.productForSale = productForSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    @Override
    public String toString() {
        return String.format("%s - quantity of %d, total price = $%.2f", productForSale, quantity, productForSale.getSalesPrice(quantity));
    }
}
