package components;

import java.awt.*;
import javax.swing.*;
import main.MainFrame;

public class HeaderPanel extends JPanel {

    private JLabel pageTitleLabel;

    public HeaderPanel() {

        setPreferredSize(new Dimension(0, 60));

        setBackground(MainFrame.theme.primary);

        setLayout(new BorderLayout(MainFrame.theme.padding, 0));

        JLabel appTitleLabel = new JLabel("Mahindra University Clubs & Events Dashboard");
        appTitleLabel.setForeground(MainFrame.theme.text);
        appTitleLabel.setFont(MainFrame.theme.title_font);

        pageTitleLabel = new JLabel("Dashboard");
        pageTitleLabel.setForeground(MainFrame.theme.text);
        pageTitleLabel.setFont(MainFrame.theme.text_font);
        pageTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setFocusPainted(false);
        logoutButton.setFocusable(false);
        logoutButton.setFont(MainFrame.theme.text_font);
        logoutButton.setBackground(MainFrame.theme.bg);
        logoutButton.setForeground(MainFrame.theme.text);
        logoutButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        add(appTitleLabel, BorderLayout.WEST);
        add(pageTitleLabel, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.EAST);
    }

    public void setPageTitle(String title) {
        pageTitleLabel.setText(title);
    }
}
