package pages;

import main.Data;
import main.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventsPage extends JPanel {

    private Theme theme = new Theme();

    private final String[] descriptions = {
            "Annual Technical Fest of MU<br>Participants: 500+<br>Events: Hackathons, robotics competitions, guest lectures and more",

            "Annual Inter-College Sports Fest of MU<br>Participants: 20+ colleges from Hyderabad<br>Events: Matches in 15+ sports",

            "Annual Cultural Fest of MU<br>Participants: 300+ students<br>Events: Solo and group performances, DJ night, live band"
    };

    public EventsPage() {

        setLayout(new BorderLayout());
        setBackground(theme.bg);

        JLabel title = new JLabel("Events", SwingConstants.CENTER);
        title.setFont(theme.bigTitle);
        title.setForeground(theme.text);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(title, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(theme.bg);
        container.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        for (int i = 0; i < Data.events.size(); i++) {
            container.add(createEventCard(i));
            container.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll, BorderLayout.CENTER);
    }

    private JPanel createEventCard(int index) {

        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(135, 206, 250));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };

        card.setLayout(new BorderLayout());
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(700, 55));

        JButton button = new JButton(Data.events.get(index) + "  ▼");
        button.setFont(theme.text_font);
        button.setForeground(Color.BLACK);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Hover color
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(new Color(0, 0, 80));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.BLACK);
            }
        });

        JLabel desc = new JLabel("<html><p style='width:650px'>" + descriptions[index] + "</p></html>");
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        desc.setForeground(theme.text);
        desc.setBorder(BorderFactory.createEmptyBorder(10, 25, 15, 25));
        desc.setVisible(false);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(theme.bg);
        wrapper.add(desc, BorderLayout.CENTER);

        card.add(button, BorderLayout.NORTH);
        card.add(wrapper, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {

            private boolean expanded = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                expanded = !expanded;
                desc.setVisible(expanded);
                button.setText(Data.events.get(index) + (expanded ? "  ▲" : "  ▼"));
                revalidate();
                repaint();
            }
        });

        return card;
    }
}
