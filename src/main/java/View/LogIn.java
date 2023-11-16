package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

    private JButton loginButton;
    public LogIn() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());


        ImageIcon backgroundIcon = new ImageIcon("Tourism.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setMinimumSize(new Dimension(500,350));
        add(backgroundLabel, BorderLayout.CENTER);


        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setLayout(new GridLayout(3, 2, 10, 10));


        JLabel userLabel = new JLabel("Username:");
        JTextField userTextField = new JTextField();
        panel.add(userLabel);
        panel.add(userTextField);


        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        loginButton = new JButton("Login");
        panel2.add(loginButton);


        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogIn();
        });
    }

    public void logInButtonAddActionListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}