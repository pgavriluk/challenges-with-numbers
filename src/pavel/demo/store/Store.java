package pavel.demo.store;

import java.util.ArrayList;

public class Store {

    private final static ArrayList<ProductForSale> productForSale =  new ArrayList<>();
    private final static ArrayList<OrderItem> orderItems =  new ArrayList<>();

    public static void main(String[] args) {
        Chair myChair = new Chair("Office Chair", 77.00, "Tall Black Chair", 100, 45, 57);
        Table myTable = new Table("Bosses Table", 333.00, "Large Rectangular Table", 100, 245, 65);

        productForSale.add(myChair);
        productForSale.add(myTable);

        for(ProductForSale pr : productForSale){
            if (pr instanceof Chair chair) {
                chair.showDetails();
                chair.printPricedItem(4);
            } else if (pr instanceof Table table){
                table.showDetails();
                table.printPricedItem(1);
            } else {
                pr.printPricedItem(10);
            }
        }

        addItemToOrder(myChair, 20);
        addItemToOrder(myTable, 5);
        addItemToOrder(myTable, 2);

        printOrderItems();
    }

    private static void addItemToOrder(ProductForSale item, int quantity){
        OrderItem newItem = new OrderItem(quantity, item);
        int index = findItem(newItem);
        if(index != -1){
            orderItems.get(index).updateQuantity(quantity);
        } else {
            orderItems.add(newItem);
        }
    }


    private static void printOrderItems(){
        System.out.println("Order:");
        double totalAmount = 0;
        for(OrderItem order : orderItems){
            System.out.println(order);
            totalAmount += order.getProductForSale().getSalesPrice(order.getQuantity());
        }
        System.out.println("_".repeat(30));
        System.out.printf("Total amount: $%6.2f %n", totalAmount);
    }

    private static int findItem(OrderItem item){
        for(OrderItem i : orderItems){
            if(i.getProductForSale().getType().equals(item.getProductForSale().getType())){
                return orderItems.indexOf(i);
            }
        }

        return -1;
    }
}
