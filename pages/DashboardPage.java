package pages;

import javax.swing.*;
import java.awt.*;
import main.Data;
import main.MainFrame;
import main.Router;

public class DashboardPage extends JPanel {

    public DashboardPage() {

        setLayout(null);
        setBackground(MainFrame.theme.bg);

        JLabel title = new JLabel("Dashboard");
        title.setFont(MainFrame.theme.bigTitle);
        title.setBounds(350, 20, 300, 40);
        add(title);

        // CARDS
        add(createCard("Total Clubs", String.valueOf(Data.clubs.size()), MainFrame.theme.cardBlue, 250, 90));
        add(createCard("Total Events", String.valueOf(Data.events.size()), MainFrame.theme.cardPurple, 500, 90));
        add(createCard("Participants", "10000+", MainFrame.theme.cardYellow, 750, 90));

        // WELCOME MESSAGE
        String user = (Data.currentUser == null ? "" : Data.currentUser);
        JLabel welcome = new JLabel("Welcome, " + user);
        welcome.setFont(MainFrame.theme.text_font);
        welcome.setBounds(250, 240, 500, 30);
        add(welcome);

        // BUTTONS
        JButton clubsBtn = new JButton("Go to Clubs");
        clubsBtn.setBounds(250, 300, 150, 40);
        add(clubsBtn);

        JButton eventsBtn = new JButton("Go to Events");
        eventsBtn.setBounds(420, 300, 150, 40);
        add(eventsBtn);

        clubsBtn.addActionListener(e -> {
            Router.goTo("Clubs", "Clubs");
            MainFrame.instance.getHeaderPanel().setPageTitle("Clubs");
        });

        eventsBtn.addActionListener(e -> {
            Router.goTo("Events", "Events");
            MainFrame.instance.getHeaderPanel().setPageTitle("Events");
        });
    }

    private JPanel createCard(String title, String number, Color color, int x, int y) {

        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };

        card.setLayout(null);
        card.setBounds(x, y, 220, 120);
        card.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(MainFrame.theme.text_font);
        titleLabel.setBounds(20, 10, 200, 30);
        card.add(titleLabel);

        JLabel numLabel = new JLabel(number);
        numLabel.setForeground(Color.WHITE);
        numLabel.setFont(MainFrame.theme.cardNumberFont);
        numLabel.setBounds(20, 50, 200, 40);
        card.add(numLabel);

        return card;
    }
}
