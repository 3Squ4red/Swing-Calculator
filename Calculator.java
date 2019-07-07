import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

class Calculator implements ActionListener {
    JTextField field, ans;
    JFrame frame;
    Calculator() {
//        The parent frame
        frame = new JFrame("Calculator");
        frame.setSize(790, 550);
        frame.setLocation(350, 100);
        frame.setLayout(null);
        frame.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Calculator.ico");
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        Display Screen
        field = new JTextField();
        field.setEditable(true);
        Font font = new Font("Cooper Black", Font.PLAIN, 20);
        field.setFont(font);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setSize(395, 100);
        field.setLocation(0, 0);
        field.setActionCommand("done");
        field.addActionListener(this);

//        Equals sign
        JLabel equal = new JLabel("=");
        equal.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        equal.setSize(100, 100);
        equal.setLocation(397, 0);
        //Answer Screen
        ans = new JTextField();
        ans.setEditable(false);
        ans.setFont(font);
        ans.setBackground(Color.GREEN);
        ans.setHorizontalAlignment(JTextField.LEFT);
        ans.setSize(370, 100);
        ans.setLocation(420, 0);
        // RESTRICTING THE INPUT TO NUMBERS ONLY!
//        PlainDocument doc = (PlainDocument) field.getDocument();
//        doc.setDocumentFilter(new MyIntFilter());

//        Numbered Buttons
        JButton[] buttons = new JButton[10];
        int x = 0, y = 120, col = 1;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(i+"");
            buttons[i].setSize(100, 100);
            buttons[i].setLocation(x, y);
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
            if (col == 3) {
                y += 100;
                x = 0;
                col = 0;
            } else x += 100;
            col++;
        }
//        dot button
        JButton dot = new JButton(".");
        dot.setSize(100, 100);
        dot.addActionListener(this);
        dot.setFont(font);
        dot.setLocation(100, 420);
//        EqualsButton
        JButton equals = new JButton("=");
        equals.setSize(100, 100);
        equals.setFont(font);
        equals.setLocation(200, 420);
        equals.addActionListener(this);

//        Operation Buttons
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");

        plus.setFont(font);
        minus.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);

        plus.setSize(100, 100);
        minus.setSize(100, 100);
        multiply.setSize(100, 100);
        divide.setSize(100, 100);

        plus.setLocation(350, 120);
        minus.setLocation(460, 120);
        multiply.setLocation(350, 220);
        divide.setLocation(460, 220);

        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

//        Delete Button and Clear buttons
        JButton delete = new JButton("DEL");
        JButton clear = new JButton("CLS");

        delete.setSize(100, 100);
        delete.setLocation(350, 320);
        delete.setFont(font);
        delete.addActionListener(this);
        clear.setFont(font);
        clear.setSize(100, 100);
        clear.setLocation(460, 320);
        clear.addActionListener(this);

//        PI and sqrt buttons
        JButton pi = new JButton("PI");
        JButton sqrt = new JButton("sqrt");

        pi.setSize(100, 100);
        sqrt.setSize(100, 100);
        pi.setFont(font);
        sqrt.setFont(font);
        pi.setLocation(350, 420);
        sqrt.setLocation(460, 420);

        pi.addActionListener(this);
        sqrt.addActionListener(this);

//        Scientific buttons
        JButton sin = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton tan = new JButton("tan");
        JButton log = new JButton("log");

        sin.setFont(font);
        tan.setFont(font);
        cos.setFont(font);
        log.setFont(font);

        sin.setSize(100, 100);
        cos.setSize(100, 100);
        tan.setSize(100, 100);
        log.setSize(100, 100);

        sin.setLocation(570, 120);
        cos.setLocation(680, 120);
        tan.setLocation(570, 220);
        log.setLocation(680, 220);

        sin.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        log.addActionListener(this);
//        Adding everything
        frame.add(field);
        frame.add(equal);
        frame.add(ans);
        for (JButton button : buttons) frame.add(button);
        frame.add(dot);
        frame.add(equals);
        frame.add(plus);
        frame.add(minus);
        frame.add(multiply);
        frame.add(divide);
        frame.add(delete);
        frame.add(clear);
        frame.add(pi);
        frame.add(sqrt);
        frame.add(sin);
        frame.add(cos);
        frame.add(tan);
        frame.add(log);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals(".")) {
                if (field.getText().length() != 0) {
                    if (!checkLastLetter()) field.setText(field.getText() + ".");
                }
            } else if (button.getText().equals("+")) {
                if (field.getText().length() != 0) {
                    if (!checkLastLetter()) field.setText(field.getText() + "+");
                }
            } else if (button.getText().equals("-")) {
                if (field.getText().length() != 0) {
                    if (!checkLastLetter()) field.setText(field.getText() + "-");
                }
            } else if (button.getText().equals("*")) {
                if (field.getText().length() != 0) {
                    if (!checkLastLetter()) field.setText(field.getText() + "*");
                }
            } else if (button.getText().equals("/")) {
                if (field.getText().length() != 0) {
                    if (!checkLastLetter()) field.setText(field.getText() + "/");
                }
            } else if (button.getText().equals("DEL") && field.getText().length() != 0) {
                StringBuilder text = new StringBuilder(field.getText());
                text.deleteCharAt(field.getText().length() - 1);
                field.setText(text.toString());
            } else if (button.getText().equals("CLS")) {
                field.setText("");
                ans.setText("");
            } else if (button.getText().equals("=")) {
                evaluateAnswer();
            } else if (button.getText().equals("PI")) {
                field.setText(field.getText() + "3.1415");
            } else if (button.getText().equals("sqrt")) {
                createDialog("Square Root", "Enter a number: ", "sqrt");
            } else if (button.getText().equals("sin")) {
                createDialog("sine", "Enter value in Degrees", "sin");
            } else if (button.getText().equals("cos")) {
                createDialog("cosine", "Enter value in Degrees", "cos");
            } else if (button.getText().equals("tan")) {
                createDialog("tangent", "Enter value in Degrees", "tan");
            } else if (button.getText().equals("log")) {
                createDialog("LOG to the base 10", "Enter a value", "log");
            } else {
                if (!button.getText().equals("DEL")) field.setText(field.getText() + button.getText());
            }
        } catch (Exception exp) {
            // Enter is pressed inside the field
            evaluateAnswer();
        }
    }

    void evaluateAnswer() {
        if (field.getText().length() == 0)
            JOptionPane.showMessageDialog(frame, "Enter something", "I'm feeling empty", JOptionPane.INFORMATION_MESSAGE);
        else {
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("js");
            try {
                ans.setText(se.eval(field.getText()).toString());
            } catch (ScriptException ex) {
                JOptionPane.showMessageDialog(frame, "Check the expression and try again", "Syntax Error", JOptionPane.ERROR_MESSAGE);
                ans.setText("");
            }
        }
    }

    void createDialog(String title, String text, String buttonText) {
        Object[] options = {"Use"};
        JPanel panel = new JPanel();
        JLabel label = new JLabel(text);
        JTextField textField = new JTextField(10);
        panel.add(label);
        panel.add(textField);

        // Uncomment to restrict the input to numbers only
//                PlainDocument doc = (PlainDocument) textField.getDocument();
//                doc.setDocumentFilter(new MyIntFilter());

        int n = JOptionPane.showOptionDialog(frame,
                panel,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        try {
            if (n == 0)  {
                if (buttonText.equals("sqrt")) field.setText(field.getText() + Math.sqrt(Double.parseDouble(textField.getText())));
                else if (buttonText.equals("sin")) field.setText(field.getText() + Math.sin(Math.toRadians(Double.parseDouble(textField.getText()))));
                else if (buttonText.equals("cos")) field.setText(field.getText() + Math.cos(Math.toRadians(Double.parseDouble(textField.getText()))));
                else if (buttonText.equals("tan")) field.setText(field.getText() + Math.tan(Math.toRadians(Double.parseDouble(textField.getText()))));
                else if (buttonText.equals("log")) field.setText(field.getText() + Math.log10(Double.parseDouble(textField.getText())));
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(frame, "Please enter valid characters", "Invalid characters", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    boolean checkLastLetter() {
        String lastLetter = field.getText().charAt(field.getText().length()-1) + "";
        return lastLetter.equals("+") || lastLetter.equals("-") ||
                lastLetter.equals("*") || lastLetter.equals("/") ||
                lastLetter.equals(".");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
