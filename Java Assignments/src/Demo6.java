// Abstract class
abstract class Account {
    private String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Interface for deposit operation
interface Depositable {
    void deposit(double amount);
}

// Interface for withdraw operation
interface Withdrawable {
    void withdraw(double amount);
}

// Interface for interest calculation
interface InterestCalculable {
    double calculateInterest();
}

// SavingsAccount class
class SavingsAccount extends Account implements Depositable, Withdrawable, InterestCalculable {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " into Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from Savings Account.");
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * (interestRate / 100);
    }
}

// CurrentAccount class
class CurrentAccount extends Account implements Depositable, Withdrawable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " into Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from Current Account.");
        } else {
            System.out.println("Withdrawal denied. Exceeds overdraft limit.");
        }
    }
}

// Main class to test the program
public class Demo6 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 1000, 3);
        CurrentAccount current = new CurrentAccount("CA456", 2000, 500);

        savings.deposit(500);
        savings.withdraw(300);
        System.out.println("Interest on Savings Account: $" + savings.calculateInterest());

        current.deposit(1000);
        current.withdraw(2500);
    }
}
