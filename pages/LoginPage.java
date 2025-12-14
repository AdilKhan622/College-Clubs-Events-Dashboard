package pages;

import main.*;
import components.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginPage() {
        
        setLayout(null);
        setBackground(MainFrame.theme.bg);

        JLabel title = new JLabel("Login to Continue");
        title.setFont(MainFrame.theme.title_font);
        title.setBounds(300, 50, 400, 40);
        add(title);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(MainFrame.theme.text_font);
        usernameLabel.setBounds(250, 150, 200, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(350, 150, 200, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(MainFrame.theme.text_font);
        passwordLabel.setBounds(250, 200, 200, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350, 200, 200, 30);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 260, 200, 40);
        loginButton.setBackground(MainFrame.theme.primary);
        loginButton.setForeground(MainFrame.theme.text);
        loginButton.setFont(MainFrame.theme.text_font);
        add(loginButton);

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(350, 310, 300, 30);
        add(errorLabel);

        loginButton.addActionListener(e -> attemptLogin());
    }

    private void attemptLogin() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple default login
        if (username.equals("admin") && password.equals("1234")) {

            Data.currentUser = username;

            // Switch to dashboard
            Router.goTo("Dashboard", "Dashboard");
            MainFrame.instance.getHeaderPanel().setPageTitle("Dashboard");

            // Make side menu visible after login
            MainFrame.instance.sideMenu.setVisible(true);

        } else {
            errorLabel.setText("Invalid username or password!");
        }
    }
}
    