package main;

import javax.swing.*;
import java.awt.*;
import components.HeaderPanel;
import components.SideMenu;

public class MainFrame extends JFrame {
    public static MainFrame instance;
    public CardLayout cardLayout;
    public JPanel mainPanel;

    private HeaderPanel headerPanel;
    private SideMenu sideMenu;

    public MainFrame() {
        instance = this;
        setTitle("College Clubs & Events Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel, BorderLayout.CENTER);

        sideMenu = new SideMenu(new Router());
        add(sideMenu, BorderLayout.WEST);

        registerPages();
    }

    private void registerPages() {

    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }
}
