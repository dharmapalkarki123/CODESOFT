package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverterGUI extends JFrame {

    private JTextField baseCurrencyField;
    private JTextField targetCurrencyField;
    private JTextField amountField;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(766, 294);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(6, 2, 10, 10));

        JLabel label = new JLabel("Base Currency (e.g., USD):");
        label.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(label);
        baseCurrencyField = new JTextField();
        baseCurrencyField.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(baseCurrencyField);

        JLabel label_1 = new JLabel("Target Currency (e.g., NPR):");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(label_1);
        targetCurrencyField = new JTextField();
        targetCurrencyField.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(targetCurrencyField);

        JLabel label_2 = new JLabel("Amount:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(label_2);
        amountField = new JTextField();
        amountField.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(amountField);

        convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(convertButton);

        resultLabel = new JLabel("Converted amount will appear here");
        resultLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        resultLabel.setForeground(Color.BLUE);
        getContentPane().add(resultLabel);

        JLabel label_3 = new JLabel("");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 10));
        getContentPane().add(label_3); // Placeholder for layout

        // Convert button logic
        convertButton.addActionListener(e -> performConversion());
    }

    private void performConversion() {
        String base = baseCurrencyField.getText().trim().toUpperCase();
        String target = targetCurrencyField.getText().trim().toUpperCase();
        String amtText = amountField.getText().trim();

        if (base.isEmpty() || target.isEmpty() || amtText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amtText);
            ExchangeRateProvider provider = new ApiExchangeRateProvider();
            CurrencyConverter converter = new CurrencyConverter(base, target, amount, provider);
            String result = converter.getConvertedResultString(); // use the reused logic
            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
