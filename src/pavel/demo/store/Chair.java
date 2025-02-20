package pavel.demo.store;

public class Chair extends  ProductForSale{

    private final int height;
    private final int width;
    private final int length;

    public Chair(String type, double price, String description, int height, int width, int length) {
        super(type, price, description);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    public void showDetails() {
        System.out.printf("The chair is %d * %d * %d%n", this.width, this.height, this.length);
    }

    @Override
    public String toString() {
        return super.getType();
    }
}
