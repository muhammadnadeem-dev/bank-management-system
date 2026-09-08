// Bank class manages all customers in the banking system.
import java.util.ArrayList;

public class Bank {

    // Instance variables
    private String bankName;
    private ArrayList<Customer> customers;
    private int bankId;

    // static variable 
    public static int totalCustomers = 0;

    public Bank() {
        customers = new ArrayList<>();
        bankName = "";
        bankId = 0;
    }

    public Bank(String name, int id) {
        this.bankName = name;
        this.bankId = id;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
        totalCustomers++;   
    }

    // FIND CUSTOMER
    public Customer findCustomer(int id) {
        for (Customer c : customers) {
            if (c.getCustomerID() == id) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getBankName() {
        return bankName;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankName(String name) {
        bankName = name;
    }

    public void setBankId(int id) {
        bankId = id;
    }

    // toString
    public String toString() {
        return "Bank: " + bankName +
               ", ID: " + bankId +
               ", Customers: " + customers.size() +
               ", Total Customers: " + totalCustomers;
    }
}