package pages;

import main.Data;
import main.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubsPage extends JPanel {

    private Theme theme = new Theme();

    private final String[] descriptions = {
            "The robotics and automation club. We focus on making robots and automating things.",
            "Coding club focused on problem solving and hackathons. We solve the biggest problems using programming.",
            "Dance and choreography club. If you love to dance, join us.",
            "Crypto, web3 and blockchain is what we do.",
            "Music, band and vocal performance club. We do jamming sessions too."
    };

    public ClubsPage() {

        setLayout(new BorderLayout());
        setBackground(theme.bg);

        JLabel title = new JLabel("Clubs", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(theme.text);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(theme.bg);
        container.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        for (int i=0;i<Math.min(5, Data.clubs.size());i++) {
            container.add(createClubButton(i));
        }

        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createClubButton(int index) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(theme.bg);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        JButton button = new JButton(Data.clubs.get(index) + "   ▼");
        button.setFont(theme.text_font);
        button.setForeground(Color.BLACK);
        button.setBackground(theme.primary);
        button.setFocusPainted(false);
        button.setRolloverEnabled(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JLabel description = new JLabel(descriptions[index], SwingConstants.CENTER);
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setForeground(theme.text);
        description.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        description.setVisible(false);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);


        button.addActionListener(new ActionListener() {

            private boolean expanded = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                expanded = !expanded;
                description.setVisible(expanded);

                if (expanded) {
                    button.setText(Data.clubs.get(index) + "   ▲");
                } else {
                    button.setText(Data.clubs.get(index) + "   ▼");
                }

                revalidate();
                repaint();
            }
        });

        panel.add(button);
        panel.add(description);

        return panel;
    }
}
