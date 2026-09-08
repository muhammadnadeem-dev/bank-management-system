// Customer class represents a bank customer who can have multiple accounts.
import java.util.ArrayList;         // Used to store dynamic lists 

public class Customer {

    // Instance variables
    private int customerID;
    private String name;
    private int age;
    
    // A customer can have multiple accounts
    private ArrayList<Account> accounts;

    // Default constructor
    public Customer() {
        customerID = 0;
        name = "";
        age = 0;
        accounts = new ArrayList<Account>();
    }

    // Constructor with parameters
    public Customer(int id, String name, int age) {
        this.customerID = id;
        this.name = name;
        this.age = age;
        accounts = new ArrayList<>();
    }

    // Add account (composition method)
    public void addAccount(Account a) {
        accounts.add(a);
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Setters
    public void setCustomerID(int id) {
        customerID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString
    public String toString() {
        return "Customer ID: " + customerID +
               ", Name: " + name +
               ", Age: " + age +
               ", Number of Accounts: " + accounts.size();
    }
}