
//import packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CalculatorGUI extends JFrame implements ActionListener {
    protected JTextField display = new JTextField();
    private JButton[] buttons = new JButton[16];
    private String[] labels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "/"
    };
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public CalculatorGUI() {
        setLayout(new BorderLayout());
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(labels[i]);
            panel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        add(panel, BorderLayout.CENTER);

        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.charAt(0) == '+' ||
                command.charAt(0) == '-' ||
                command.charAt(0) == '*' ||
                command.charAt(0) == '/' ||
                command.equals("=")) {
            if (calculating) {
                operator = command;
                result = Double.parseDouble(display.getText());
                calculating = false;
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = command;
                result = x;
            }
        } else {
            if (calculating) {
                display.setText(command);
                calculating = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+")) {
            result += n;
        } else if (operator.equals("-")) {
            result -= n;
        } else if (operator.equals("*")) {
            result *= n;
        } else if (operator.equals("/")) {
            result /= n;
        } else if (operator.equals("=")) {
            result = n;
        }
        display.setText("" + result);
        calculating = true;
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
