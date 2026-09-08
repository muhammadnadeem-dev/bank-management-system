 // SavingsAccount class extends Account. Represents a savings account with interest and minimum balance rules.
public class SavingsAccount extends Account {

    // Instance variables
    private double minBalance;
    private double interestRate;
    private String accountType; 

    // Default constructor
    public SavingsAccount() {
        super(0, 0.0, null);
        minBalance = 0.0;
        interestRate = 0.0;
        accountType = "Savings";
    }

    // Constructor with parameters
    public SavingsAccount(int num, double bal, Customer owner,
                          double min, double rate) {
        super(num, bal, owner);
        minBalance = min;
        interestRate = rate;
        accountType = "Savings";
    }

    // Method specific to savings account
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    // Overridden withdraw method: it ensures balance does not go below minimum balance
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= minBalance) {
            super.withdraw(amount);
        }
    }

    // Getters
    public double getMinBalance() {
        return minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getAccountType() {
        return accountType;
    }

    // Setters
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Returns savings account information
    public String toString() {
        return super.toString() +
               "\nType: " + accountType +
               "\nInterest Rate: " + interestRate +
               "\nMin Balance: " + minBalance;
    }
}