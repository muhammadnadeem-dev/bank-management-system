public class Account {

    // Instance variables 
    private int accountNumber;
    private double balance;
    private Customer owner;

    // Default constructor
    public Account() {
        accountNumber = 0;
        balance = 0.0;
        owner = null;
    }

    // Parameterized constructor
    public Account(int accountNumber, double balance, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    // Getters and setters 

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    // Deposit money into account
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Withdraw money from account
    public void withdraw(double amount) {
        if (amount > 0) {
            balance = balance - amount;
        }
    }

    // Returns account information
    public String toString() {
        return "Account Number: " + accountNumber +
               "\nBalance: $" + balance;
    }
}