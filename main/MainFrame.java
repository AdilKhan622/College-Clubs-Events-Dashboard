package main;

import javax.swing.*;
import java.awt.*;
import components.HeaderPanel;
import components.SideMenu;
import pages.ClubsPage;
import pages.EventsPage;

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
        registerPages();

        cardLayout.show(mainPanel, "Empty");
    }

    private void registerPages() {
        JPanel emptyPage = new JPanel();
        emptyPage.setBackground(theme.bg);
        mainPanel.add(emptyPage, "Empty");

        ClubsPage clubsPage = new ClubsPage();
        mainPanel.add(clubsPage, "Clubs");

        EventsPage eventsPage = new EventsPage();
        mainPanel.add(eventsPage, "Events");
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }
}
