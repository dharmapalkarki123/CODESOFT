package ATMinterface.com;

import java.util.Scanner;

// 1. BankAccount class to manage balance
class BankAccount {
    private int balance;

    public String deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposited ₹" + amount;
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(int amount) {
        if (amount <= 0) {
            return "Invalid withdraw amount.";
        } else if (amount > balance) {
            return "Insufficient balance!";
        } else {
            balance -= amount;
            return "Withdrawn ₹" + amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}

// 2. ATMUser interface
interface ATMUser {
    void depositing();
    void withdrawing();
    void checkingBalance();
}

// 3. ATM Implementation class
class AtmImp implements ATMUser {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public AtmImp(BankAccount account) {
        this.account = account;
    }

    @Override
    public void depositing() {
        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();
        account.deposit(amount);
    }

    @Override
    public void withdrawing() {
        System.out.print("Enter withdraw amount: ");
        int amount = sc.nextInt();
        account.withdraw(amount);
    }

    @Override
    public void checkingBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}

// 4. Main ATM class with menu
public class ATMInt {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount();
        AtmImp atm = new AtmImp(userAccount);
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> atm.depositing();
                case 2 -> atm.withdrawing();
                case 3 -> atm.checkingBalance();
                case 4 -> {
                    System.out.println("Thank you for using the ATM Service");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close(); 
    }
}
