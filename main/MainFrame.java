package main;

import javax.swing.*;
import java.awt.*;

import components.HeaderPanel;
import components.SideMenu;
import pages.ClubsPage;
import pages.EventsPage;
import pages.LoginPage;
import pages.DashboardPage;

public class MainFrame extends JFrame {

    public static final Theme theme = new Theme();
    public static MainFrame instance;

    public JPanel mainPanel;
    public CardLayout cardLayout;
    public SideMenu sideMenu;
    private HeaderPanel headerPanel;

    public MainFrame() {

        instance = this;

        setTitle("College Clubs & Events Dashboard");
        setSize(1050, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        sideMenu = new SideMenu(new Router());
        sideMenu.setVisible(false);
        add(sideMenu, BorderLayout.WEST);
        

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel, BorderLayout.CENTER);

        registerPages();

        cardLayout.show(mainPanel, "Login");
        headerPanel.setPageTitle("Login");

        setVisible(true);
    }

    private void registerPages() {
        mainPanel.add(new LoginPage(), "Login");
        mainPanel.add(new DashboardPage(), "Dashboard");
        mainPanel.add(new ClubsPage(), "Clubs");
        mainPanel.add(new EventsPage(), "Events");

        JPanel regPage = new JPanel();
        regPage.setBackground(theme.bg);
        mainPanel.add(regPage, "Registrations");

        JPanel finPage = new JPanel();
        finPage.setBackground(theme.bg);
        mainPanel.add(finPage, "Finance");
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }
}
