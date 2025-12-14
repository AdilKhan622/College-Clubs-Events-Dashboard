package components;

import java.awt.*;
import javax.swing.*;
import main.Data;
import main.MainFrame;
import main.Router;

public class HeaderPanel extends JPanel {

    private JLabel pageTitleLabel;

    public HeaderPanel() {

        setPreferredSize(new Dimension(0, 60));

        // Make the existing light-blue theme color slightly darker
        Color p = MainFrame.theme.primary;
        Color darkerPrimary = new Color(
                Math.max(0, (int)(p.getRed()   * 0.85f)),
                Math.max(0, (int)(p.getGreen() * 0.85f)),
                Math.max(0, (int)(p.getBlue()  * 0.85f))
        );
        setBackground(darkerPrimary);
        setOpaque(true);

        setLayout(new BorderLayout(20, 0));

        // LEFT: App title
        JLabel appTitleLabel = new JLabel("Mahindra University Clubs & Events");
        appTitleLabel.setForeground(MainFrame.theme.text);
        appTitleLabel.setFont(MainFrame.theme.title_font);

        // CENTER: Page Title
        pageTitleLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        pageTitleLabel.setForeground(MainFrame.theme.text);
        pageTitleLabel.setFont(MainFrame.theme.text_font);

        // RIGHT: Logout only
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        rightPanel.setOpaque(false);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setFocusPainted(false);
        logoutButton.setBackground(MainFrame.theme.bg);
        logoutButton.setForeground(MainFrame.theme.text);
        logoutButton.setFont(MainFrame.theme.text_font);

        logoutButton.addActionListener(e -> {
            Data.currentUser = null;
            MainFrame.instance.sideMenu.setVisible(false);
            Router.goTo("Login", "Login");
            setPageTitle("Login");
        });

        rightPanel.add(logoutButton);

        add(appTitleLabel, BorderLayout.WEST);
        add(pageTitleLabel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    public void setPageTitle(String title) {
        pageTitleLabel.setText(title);
    }
}
