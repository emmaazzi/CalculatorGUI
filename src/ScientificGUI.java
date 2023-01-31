import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScientificGUI extends CalculatorGUI {

    private JButton[] scientificButtons = new JButton[5];
    private String[] scientificLabels = {
            "sin", "cos", "tan", "log", "sqrt"
    };

    public ScientificGUI() {
        super();
        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(new GridLayout(1, 5));
        for (int i = 0; i < 5; i++) {
            scientificButtons[i] = new JButton(scientificLabels[i]);
            panel.add(scientificButtons[i]);
            scientificButtons[i].addActionListener(this);
        }
        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("sin")) {
            double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sin(x)));
        } else if (command.equals("cos")) {
            double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.cos(x)));
        } else if (command.equals("tan")) {
            double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.tan(x)));
        } else if (command.equals("log")) {
            double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.log10(x)));
        } else if (command.equals("sqrt")) {
            double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(x)));
        } else {
            super.actionPerformed(event);
        }
    }

    public static void main(String[] args) {
        new ScientificGUI();
    }
}
