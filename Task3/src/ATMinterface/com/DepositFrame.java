package ATMinterface.com;

import javax.swing.*;

public class DepositFrame extends JFrame {
    public DepositFrame(BankAccount account) {
        setTitle("Deposit");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel label = new JLabel("Enter amount to deposit:");
        label.setBounds(50, 30, 200, 20);
        add(label);

        JTextField amountField = new JTextField();
        amountField.setBounds(50, 60, 180, 25);
        add(amountField);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 100, 100, 25);
        add(depositBtn);

        depositBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                String result = account.deposit(amount);
                JOptionPane.showMessageDialog(this, result);
                new ATMGUI(account);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid number!");
            }
        });

        setVisible(true);
    }
}

