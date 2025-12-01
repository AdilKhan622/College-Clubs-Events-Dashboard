package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.Router;

public class SideMenu extends JPanel {

    private final Router router;

    private JButton dashboardButton;
    private JButton clubsButton;
    private JButton eventsButton;
    private JButton registrationButton;
    private JButton financeButton;

    private final Color defaultBg = new Color(240, 240, 240);
    private final Color activeBg = new Color(200, 230, 255);

    public SideMenu(Router router) {
        this.router = router;

        setPreferredSize(new Dimension(200, 0));
        setLayout(new GridLayout(0, 1, 0, 8));
        setBorder(BorderFactory.createEmptyBorder(16, 8, 16, 8));
        setBackground(defaultBg);

        dashboardButton = createMenuButton("Dashboard", "dashboard", "Dashboard");
        clubsButton = createMenuButton("Clubs", "clubs", "Clubs");
        eventsButton = createMenuButton("Events", "events", "Events");
        registrationButton = createMenuButton("Registrations", "registrations", "Registrations");
        financeButton = createMenuButton("Finance", "finance", "Finance");

        add(dashboardButton);
        add(clubsButton);
        add(eventsButton);
        add(registrationButton);
        add(financeButton);

        setActive("dashboard");
    }

    private JButton createMenuButton(String text, String pageKey, String pageTitle) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBackground(defaultBg);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(pageKey, pageTitle);
                setActive(pageKey);
            }
        });

        return btn;
    }

    public void setActive(String pageKey) {
        resetBackgrounds();

        switch (pageKey) {
            case "dashboard":
                dashboardButton.setBackground(activeBg);
                break;
            case "clubs":
                clubsButton.setBackground(activeBg);
                break;
            case "events":
                eventsButton.setBackground(activeBg);
                break;
            case "registrations":
                registrationButton.setBackground(activeBg);
                break;
            case "finance":
                financeButton.setBackground(activeBg);
                break;
            default:
                break;
        }
    }

    private void resetBackgrounds() {
        dashboardButton.setBackground(defaultBg);
        clubsButton.setBackground(defaultBg);
        eventsButton.setBackground(defaultBg);
        registrationButton.setBackground(defaultBg);
        financeButton.setBackground(defaultBg);
    }
}