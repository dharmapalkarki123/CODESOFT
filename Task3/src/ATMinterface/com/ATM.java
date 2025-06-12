package ATMinterface.com;

public class ATM {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount();
        new ATMGUI(userAccount); // Start GUI
    }
}

