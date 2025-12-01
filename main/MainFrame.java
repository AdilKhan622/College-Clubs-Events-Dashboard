package main;

import javax.swing.*;
import java.awt.*;
import components.HeaderPanel;
import components.SideMenu;

public class MainFrame extends JFrame {
    public static final Theme theme = new Theme();
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

        getContentPane().setBackground(theme.bg);
        setVisible(true);

        headerPanel = new HeaderPanel();
        headerPanel.setBackground(theme.primary);
        add(headerPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(theme.bg);
        add(mainPanel, BorderLayout.CENTER);

        sideMenu = new SideMenu(new Router());
        sideMenu.setBackground(theme.bg);
        add(sideMenu, BorderLayout.WEST);
        Router.goTo("Dashboard", "dashboard");

        registerPages();
    }

    private void registerPages() {

    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }
}
