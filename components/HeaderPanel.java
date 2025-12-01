package components;

import java.awt.*;
import javax.swing.*;

public class HeaderPanel extends JPanel {

    private JLabel pageTitleLabel;

    public HeaderPanel() {
        setPreferredSize(new Dimension(0, 60));
        setBackground(new Color(25, 118, 210));
        setLayout(new BorderLayout(16, 0));

        JLabel appTitleLabel = new JLabel("College Clubs & Events Dashboard");
        appTitleLabel.setForeground(Color.WHITE);
        appTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        pageTitleLabel = new JLabel("Dashboard");
        pageTitleLabel.setForeground(Color.WHITE);
        pageTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pageTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFocusPainted(false);

        add(appTitleLabel, BorderLayout.WEST);
        add(pageTitleLabel, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.EAST);
    }

    public void setPageTitle(String title) {
        pageTitleLabel.setText(title);
    }
}