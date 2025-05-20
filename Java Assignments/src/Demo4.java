// Base class: BankAccount
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to display account details (to be overridden)
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    // Method to display account details specific to SavingsAccount
    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account Details:");
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method to account for overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount >= -overdraftLimit)) {
            double newBalance = getBalance() - amount;
            // Use reflection to modify balance since it's private in the base class
            super.deposit(-amount); 
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Withdrawal denied. Exceeds overdraft limit.");
        }
    }

    // Method to display account details specific to CurrentAccount
    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account Details:");
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

// Main class to test the hierarchy
public class Demo4 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 2.5);
        CurrentAccount current = new CurrentAccount("CA67890", 2000, 1000);

        // Test SavingsAccount
        savings.deposit(1000);
        savings.withdraw(1500);
        savings.displayAccountDetails();

        // Test CurrentAccount
        current.deposit(500);
        current.withdraw(3000); // Should consider overdraft
        current.displayAccountDetails();
    }
}

