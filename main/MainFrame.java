package main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public CardLayout cardLayout;
    public JPanel mainPanel;

    public MainFrame() {

        setTitle("College Clubs & Events Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);
    }
}
