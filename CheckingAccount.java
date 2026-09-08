// CheckingAccount class extends Account. Represents a bank account that allows overdraft with a fee.
public class CheckingAccount extends Account {

    // Instance variables
    private double overdraftFee;
    private String accountType;
    private double dailyLimit;

    // Default constructor
    public CheckingAccount() {
        super(0, 0.0, null);
        overdraftFee = 0.0;
        accountType = "Checking";
        dailyLimit = 0.0;
    }

    // Constructor with parameters
    public CheckingAccount(int num, double bal, Customer owner,
                           double fee, double limit) {
        super(num, bal, owner);
        overdraftFee = fee;
        accountType = "Checking";
        dailyLimit = limit;
    }

    // Overridden withdraw method. Applies overdraft fee if balance is not enough
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            double newBalance = getBalance() - amount - overdraftFee;
            setBalance(newBalance);
        }
    }

    // Getters
    public double getOverdraftFee() {
        return overdraftFee;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    // Setters
    public void setOverdraftFee(double fee) {
        overdraftFee = fee;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public void setDailyLimit(double limit) {
        dailyLimit = limit;
    }

    // Returns checking account information
    @Override
    public String toString() {
        return super.toString() +
               "\nType: " + accountType +
               "\nOverdraft Fee: " + overdraftFee +
               "\nDaily Limit: " + dailyLimit;
    }
}