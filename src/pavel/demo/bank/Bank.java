package pavel.demo.bank;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            return this.branches.add(new Branch(branchName));
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }

        return false;
    }

    private Branch findBranch(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(name)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.printf("Customer details for branch %s%n", branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                System.out.printf("Customer: %s[%d]%n", customers.get(i).getName(), i+1);
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    for (int j = 1; j <= transactions.size(); j++) {
                        System.out.printf("[%d] Amount %.2f%n", j, transactions.get(j-1));
                    }
                }
            }
            return true;
        }

        return false;
    }

}
