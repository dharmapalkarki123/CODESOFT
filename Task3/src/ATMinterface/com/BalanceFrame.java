package ATMinterface.com;

import javax.swing.*;

public class BalanceFrame extends JFrame {
    public BalanceFrame(BankAccount account) {
        setTitle("Check Balance");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel balanceLabel = new JLabel("Your current balance is: ₹" + account.getBalance());
        balanceLabel.setBounds(50, 40, 250, 30);
        add(balanceLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 80, 80, 25);
        add(backButton);

        backButton.addActionListener(e -> {
            new ATMGUI(account);
            dispose();
        });

        setVisible(true);
    }
}
