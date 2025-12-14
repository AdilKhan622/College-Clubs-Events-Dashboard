package pages;

import main.Data;
import main.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClubsPage extends JPanel {

    private Theme theme = new Theme();

    private final String[] descriptions = {
            "The robotics and automation club. We focus on making robots and automating things.",
            "The computer science club of MU focused on problem solving, workshops and hackathons.",
            "Dance and choreography club. If you love to dance, join us.",
            "Crypto, Web3, Smart Contracts and Blockchain is what we specialize in.",
            "Music, band and vocal performance club. We do jamming sessions too."
    };

    public ClubsPage() {

        setLayout(new BorderLayout());
        setBackground(theme.bg);

        JLabel title = new JLabel("Clubs", SwingConstants.CENTER);
        title.setFont(theme.bigTitle);
        title.setForeground(theme.text);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(title, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(theme.bg);
        container.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        for (int i = 0; i < Data.clubs.size(); i++) {
            container.add(createClubCard(i));
            container.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll, BorderLayout.CENTER);
    }

    private JPanel createClubCard(int index) {

        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Card background
                g2.setColor(new Color(135, 206, 250));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };

        card.setLayout(new BorderLayout());
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(700, 55));

        JButton button = new JButton(Data.clubs.get(index) + "  ▼");
        button.setFont(theme.text_font);
        button.setForeground(Color.BLACK);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Hover effect
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

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
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
                button.setText(Data.clubs.get(index) + (expanded ? "  ▲" : "  ▼"));
                revalidate();
                repaint();
            }
        });

        return card;
    }
}
