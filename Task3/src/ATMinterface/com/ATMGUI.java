package ATMinterface.com;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class ATMGUI extends JFrame {
    private BankAccount account;

    public ATMGUI(BankAccount account) {
        this.account = account;

        setTitle("ATM SERVICE");
        setSize(645, 365);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);


        JLabel titleLabel = new JLabel("Welcome to ATM Interface");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        titleLabel.setBounds(248, 31, 183, 30);
        getContentPane().add(titleLabel);

        JButton depositButton = new JButton("1. Deposit");
        depositButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        depositButton.setBounds(248, 71, 150, 30);
        getContentPane().add(depositButton);

        JButton withdrawButton = new JButton("2. Withdraw");
        withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        withdrawButton.setBounds(248, 111, 150, 30);
        getContentPane().add(withdrawButton);

        JButton balanceButton = new JButton("3. Check Balance");
        balanceButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        balanceButton.setBounds(248, 151, 150, 30);
        getContentPane().add(balanceButton);

        JButton exitButton = new JButton("4. Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        exitButton.setBounds(248, 191, 150, 30);
        getContentPane().add(exitButton);

        // Button Actions
        depositButton.addActionListener(e -> {
            new DepositFrame(account);
            dispose(); // close current frame
        });

        withdrawButton.addActionListener(e -> {
            new WithdrawFrame(account);
            dispose();
        });

        balanceButton.addActionListener(e -> {
            new BalanceFrame(account);
            dispose();
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thank you for using the ATM Service");
            System.exit(0);
        });

        setVisible(true);
    }
}

