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

        getContentPane().add(new JLabel("Base Currency (e.g., USD):"));
        baseCurrencyField = new JTextField();
        getContentPane().add(baseCurrencyField);

        getContentPane().add(new JLabel("Target Currency (e.g., NPR):"));
        targetCurrencyField = new JTextField();
        getContentPane().add(targetCurrencyField);

        getContentPane().add(new JLabel("Amount:"));
        amountField = new JTextField();
        getContentPane().add(amountField);

        convertButton = new JButton("Convert");
        getContentPane().add(convertButton);

        resultLabel = new JLabel("Converted amount will appear here");
        resultLabel.setForeground(Color.BLUE);
        getContentPane().add(resultLabel);

        getContentPane().add(new JLabel("")); // Placeholder for layout

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
