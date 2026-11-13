import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class FeePaymentGUI extends JFrame {

    private JTextField nameField, regField, amountField;
    private JLabel statusLabel;
    private String lastReceipt = "";

    private final FeeService feeService = new FeeService();

    public FeePaymentGUI() {
        setTitle("Student Fee Payment");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nameField = new JTextField();
        regField = new JTextField();
        amountField = new JTextField();
        statusLabel = new JLabel("Enter fee details");

        JButton payButton = new JButton("Pay Fee");
        JButton receiptButton = new JButton("Receipt");
        JButton clearButton = new JButton("Clear");

        panel.add(new JLabel("Student Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Register Number:"));
        panel.add(regField);
        panel.add(new JLabel("Fee Amount:"));
        panel.add(amountField);
        panel.add(payButton);
        panel.add(receiptButton);
        panel.add(clearButton);
        panel.add(statusLabel);

        add(panel);

        payButton.addActionListener(e -> payFee());
        receiptButton.addActionListener(e -> showReceipt());
        clearButton.addActionListener(e -> clearFields());
    }

    private void payFee() {
        try {
            String name = nameField.getText().trim();
            String reg = regField.getText().trim();
            BigDecimal amount = new BigDecimal(
                amountField.getText().trim()
            );

            String result = feeService.processPayment(name, reg, amount);
            lastReceipt = result;
            statusLabel.setText("Payment successful");
            JOptionPane.showMessageDialog(this, result);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                this, ex.getMessage(),
                "Input Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showReceipt() {
        if (lastReceipt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No receipt available.");
        } else {
            JOptionPane.showMessageDialog(this, lastReceipt);
        }
    }

    private void clearFields() {
        nameField.setText("");
        regField.setText("");
        amountField.setText("");
        statusLabel.setText("Enter fee details");
        lastReceipt = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new FeePaymentGUI().setVisible(true)
        );
    }
}

class FeeService {

    public String processPayment(
        String name, String reg, BigDecimal amount
    ) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Enter student name.");
        }

        if (reg == null || reg.isEmpty()) {
            throw new IllegalArgumentException("Enter register number.");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Fee amount must be greater than zero."
            );
        }

        return "FEE PAYMENT RECEIPT\n"
            + "Student: " + name + "\n"
            + "Register Number: " + reg + "\n"
            + "Amount: Rs. " + amount.toPlainString()
            + "\nPayment Status: Successful";
    }
}
