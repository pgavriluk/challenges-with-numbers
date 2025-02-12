package pavel.demo.bill;

public class Hamburger {

    private String type;
    private double basePrice;
    private double additionalPrice;
    private String topping1 = "";
    private String topping2 = "";
    private String topping3 = "";
    private String deluxeTopping1 = "";
    private String deluxeTopping2 = "";
    private boolean deluxe;

    public Hamburger(String type, double basePrice) {
        this(type, basePrice, false);
    }

    public Hamburger(boolean deluxe){
        this(deluxe ? "Deluxe Burger" : "Regular Burger", deluxe ? 20.00 : 10.99, deluxe);
    }

    public Hamburger(String type, double basePrice, boolean deluxe) {
        this.type = type;
        this.deluxe = deluxe;
        if (type.contains("Regular")) {
            this.topping1 = "Lettuce";
            this.topping2 = "Tomato";
        }
        if (deluxe){
            this.basePrice = 20.00;
        } else{
            this.basePrice = basePrice;
        }
    }

    public Hamburger addTopping(String topping) {
        double price = getToppingPrice(topping);
        if (price == -1.00) {
            System.out.printf("The topping '%s' is not served by Bills' Burger", topping);
            return this;
        }
        if(deluxe){
            price = 0;
        }
        if (this.topping1.isEmpty()) {
            this.topping1 = topping;
            this.additionalPrice += price;
            return this;
        } else if (this.topping2.isEmpty()) {
            this.topping2 = topping;
            this.additionalPrice += price;
            return this;
        } else if (this.topping3.isEmpty()) {
            this.topping3 = topping;
            this.additionalPrice += price;
            return this;
        } else if(deluxe && this.deluxeTopping1.isEmpty()){
            this.deluxeTopping1 = topping;
        } else if (deluxe && this.deluxeTopping2.isEmpty()) {
            this.deluxeTopping2 = topping;
        } else if (deluxe) {
            System.out.printf("Only five toppings are allowed for Deluxe Burger! Couldn't add sixth topping \"%s\" %n", topping);
            return this;
        } else {
            System.out.printf("Only three toppings are allowed! Couldn't add fourth topping \"%s\" %n", topping);
            return this;
        }

        return this;
    }

    private double getToppingPrice(String topping) {
        return switch (topping.toUpperCase()) {
            case "TOMATO" -> 0.5;
            case "LETTUCE" -> 0.1;
            case "CUCUMBER" -> 0.6;
            case "ONION" -> 0.3;
            default -> -1.00;
        };
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "type='" + type + '\'' +
                ", basePrice=" + basePrice +
                ", additionalPrice=" + additionalPrice +
                ", topping1='" + topping1 + '\'' +
                ", topping2='" + topping2 + '\'' +
                ", topping3='" + topping3 + '\'' +
                ", deluxeTopping1='" + deluxeTopping1 + '\'' +
                ", deluxeTopping2='" + deluxeTopping2 + '\'' +
                ", deluxe=" + deluxe +
                '}';
    }
}
