package main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static MainFrame instance;
    public CardLayout cardLayout;
    public JPanel mainPanel;

    public MainFrame() {
        instance = this;
        setTitle("College Clubs & Events Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        registerPages();
        Router.goTo("login");
    }

    private void registerPages() {

    }
}
