package pavel.demo.store;

public class Table extends ProductForSale{

    private final int height;
    private final int width;
    private final int length;

    public Table(String type, double price, String description, int height, int width, int length) {
        super(type, price, description);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    public void showDetails() {
        System.out.printf("The table is %d * %d * %d%n", this.width, this.height, this.length);
    }

    @Override
    public String toString() {
        return super.getType();
    }
}
