// Program: Bank Management Client.java
// Written by: Muhammad Nadeem
// Description: This program simulates a simple banking system using object-oriented programming.
// It allows users to add customers, create savings and checking accounts, and perform transactions
// such as deposits and withdrawals. The system also lets users view customer and account information
// All user interaction is handled through JOptionPane input and message dialog boxes.
// Challenges: Handling user input safely and managing object relationships.
// Time Spent: 5 hrs
// Given Input:                              Expected Output:
// ------------------                        -----------------------
// Add Customer:                             Customer created successfully!
// Name: Muhammad                            Customer ID: 234
// Age: 22                                   Random ID generated
//
// Create Savings Account:                   Congratulations! Savings account successfully created!
// Customer ID: 234                          Account #: 8456
// Account Type: S
//
// Create Checking Account:                  Congrats! Checking account successfully created!
// Customer ID: 234                          Account #: 9123
// Account Type: C
//
// Deposit Money:                            Deposit successful!
// Customer ID: 234
// Account #: 8456
// Deposit Amount: 200
//
// Withdraw Money:                           Withdraw successful!
// Customer ID: 234
// Account #: 8456
// Withdraw Amount: 50
//
// View Customer Info:                       Customer ID: 234, Name: Muhammad, Age: 22
//                                           Account Number: 8456, Balance: $150
//                                           Account Number: 9123, Balance: $0
//                                           End of Bank record
//
// Exit:                                     Thank you for using the Banking System! Hope you have a nice day!
// Revision History
// Date:               By:             Action:
// ---------------------------------------------------
// 04/24/2026         (MN)             Created and completed program
// 04/27/2026         (MN)             Added customer and account functionality
// 04/30/2026         (MN)             Implemented deposit and withdrawal features
// 05/04/2026         (MN)             Improved comments, formatting, and input handling

import javax.swing.JOptionPane;         // Used for input/output dialog boxes 
import java.util.ArrayList;             // Used to store dynamic lists 
import java.util.Random;                // Used to generate random IDs for customers and accounts

/* filename must be: Client.java */
public class Client {
    
    // Random object used to generate unique IDs for customers and accounts
    private static final Random randomNumbers = new Random();
    
    // static method
    public static int generateAccountNumber() {
        return randomNumbers.nextInt(10000);
    }

    // main method begins execution of Java application
    public static void main(String[] args) {
        
        // Step 2: Create Bank object (stores all customers)
        Bank bank = new Bank("MyBank", 325);

        // Stores the user's menu selection from the banking system menu
        int choice = 0;

        // Step 4: Main loop keeps program running until user chooses Exit
        while (choice != 6) {

            // Step 3: Display menu using JOptionPane input dialog
            String input = JOptionPane.showInputDialog(
                "BANKING SYSTEM MENU\n" +
                "1. Add Customer\n" +
                "2. Create Account\n" +
                "3. Deposit Money\n" +
                "4. Withdraw Money\n" +
                "5. View Customer Information\n" +
                "6. Exit\n" +
                "Enter your choice (1-6):"
            );

            // If user presses cancel, exit program 
            if (input == null) 
                break;

            // Convert user input from String to integer
            choice = Integer.parseInt(input);
            
            // Valoidating input
            if (choice < 1 || choice > 6) {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please select 1-6 only.");
                continue;
            }

            // OPTION 1: ADD CUSTOMER

            if (choice == 1) {

                // Ask user for customer name
                String name = JOptionPane.showInputDialog("Enter customer name:");

                // Ask user for customer age
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter customer age:"));

                // Generate random customer ID
                int id = randomNumbers.nextInt(1000);

                // Create new Customer object
                Customer c = new Customer(id, name, age);
                bank.addCustomer(c);

                // Show confirmation message
                JOptionPane.showMessageDialog(null, "Customer created successfully!\nCustomer ID: " + id);
            }

            // OPTION 2: CREATE ACCOUNT

            else if (choice == 2) {
                
                // Ask for customer ID
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));

                // Find customer in bank
                Customer c = bank.findCustomer(id);
                
                // Check if customer exists
                if (c != null) {

                    // Generate account number
                    int accNum = generateAccountNumber();

                    // Ask for account type
                    String type = JOptionPane.showInputDialog("Enter account type (S = Savings or C = Checking):");

                    if (type.equalsIgnoreCase("S")) {
                        
                        double minBalance = 100.0;
                        double interestRate = 0.05;


                        // Create Savings account
                        SavingsAccount sa = new SavingsAccount(accNum, 0.0, c, minBalance, interestRate);

                        // Add account to customer
                        c.addAccount(sa);

                        JOptionPane.showMessageDialog(null,
                            "Congratulations! Savings account successfully created!\nAccount #: " + accNum);

                    } else {
                        // variables
                        double fee = 5.0;
                        double limit = 500.0;

                        // Create Checking account
                        CheckingAccount ca = new CheckingAccount(accNum, 0.0, c, fee, limit);

                        // Add account to customer
                        c.addAccount(ca);

                        // Confirmation message
                        JOptionPane.showMessageDialog(
                            null, "Congratulations! Checking account successfully created!\nAccount #: " + accNum);
                    }

                } else {
                    // Error message
                    JOptionPane.showMessageDialog(null, "Sorry! Customer not found!");
                }
            }

            // OPTION 3: DEPOSIT MONEY

            else if (choice == 3) {

                // Ask for Customer ID
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));

                // Find customer
                Customer c = bank.findCustomer(id);

                // Check if customer and accounts exist
                if (c != null) {
                    
                    boolean found = false;
                   
                    int accNum = Integer.parseInt(JOptionPane.showInputDialog("Enter account number:"));
                    

                    for (Account a : c.getAccounts()) {

                        if (a.getAccountNumber() == accNum) {
                               
                            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                    // Perform deposit
                            a.deposit(amount);

                            JOptionPane.showMessageDialog(null, "Deposit successful!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                    // Error message 
                    JOptionPane.showMessageDialog(null, "Account not found!");
                }
            }
        }

            // OPTION 4: WITHDRAW MONEY

            else if (choice == 4) {

                // Ask for customer ID
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));

                // Find customer
                Customer c = bank.findCustomer(id);

                // Check validity
                if (c != null) {
                    
                    boolean found = false;

                    int accNum = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter account number:")
                    );
 
                    for (Account a : c.getAccounts()) {

                        if (a.getAccountNumber() == accNum) {
                            
                            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdraw amount:"));

                    // Perform withdrawal
                            a.withdraw(amount);

                    // Success message
                            JOptionPane.showMessageDialog(null, "Withdraw successful!");
                            
                            found = true;
                            break;
                        }
                    }
                    
                if (!found) {
                    // Error message
                    JOptionPane.showMessageDialog(null, "Customer or account not found!");
                }
            }
        }

            // OPTION 5: VIEW CUSTOMERS

            else if (choice == 5) {

                // Get all customers from bank
                ArrayList<Customer> list = bank.getCustomers();

                // Loop through customers
                for (Customer c : list) {

                    // Show customer info
                    JOptionPane.showMessageDialog(null, c.toString());

                    // Show account info of each customer 
                    for (Account a : c.getAccounts()) {
                        JOptionPane.showMessageDialog(null, a.toString());
                    }

                    JOptionPane.showMessageDialog(null, " Customer record Displayed ");
                }
            }
        }

        // Exit message
        JOptionPane.showMessageDialog(null, "Thank you for using the Banking System! Hope you have a nice day! ");
    }
}