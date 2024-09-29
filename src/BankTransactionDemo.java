import java.util.Scanner;

abstract class BankAccount {
    protected double balance;
    protected double maxBalance;

    public BankAccount(double initialBalance, double maxBalance) {
        this.balance = initialBalance;
        this.maxBalance = maxBalance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double accountBalance() {
        return balance;
    }

    public boolean isAccountEmpty() {
        return balance == 0;
    }

    public boolean isAccountFull() {
        return balance == maxBalance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(double initialBalance, double maxBalance) {
        super(initialBalance, maxBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else if (balance + amount > maxBalance) {
            System.out.println("Deposit exceeds the maximum account balance.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited " + amount + ". New balance: " + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount + ". New balance: " + balance);
        }
    }
}


public class BankTransactionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter maximum balance: ");
        double maxBalance = scanner.nextDouble();


        BankAccount account = new SavingsAccount(initialBalance, maxBalance);

        boolean running = true;


        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Check if Account is Empty");
            System.out.println("5. Check if Account is Full");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current balance: " + account.accountBalance());
                    break;

                case 4:
                    if (account.isAccountEmpty()) {
                        System.out.println("The account is empty.");
                    } else {
                        System.out.println("The account is not empty.");
                    }
                    break;

                case 5:
                    if (account.isAccountFull()) {
                        System.out.println("The account is full.");
                    } else {
                        System.out.println("The account is not full.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
