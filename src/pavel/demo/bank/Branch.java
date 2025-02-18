package pavel.demo.bank;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction){
        if(findCustomer(name) == null){
            return customers.add(new Customer(name, initialTransaction));
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        Customer customer = findCustomer(customerName);
        if (customer != null){
            customer.addTransaction(transaction);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String name){
        for(Customer customer : customers){
            if(customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }

        return null;
    }
}
