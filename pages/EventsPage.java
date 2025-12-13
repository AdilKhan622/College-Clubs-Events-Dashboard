package pages;

import main.Data;
import main.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventsPage extends JPanel {

    private Theme theme = new Theme();

    // Plain-text event details
    private final String[] descriptions = {
            "Annual Technical Fest of MU\n"
                    + "Participants: 500+\n"
                    + "Events: Hackathons, robotics competitions, guest lectures and more",

            "Annual Inter-College Sports Fest of MU\n"
                    + "Participants: 20+ colleges from Hyderabad\n"
                    + "Events: Matches in 15+ sports",

            "Annual Cultural Fest of MU\n"
                    + "Participants: 300+ students\n"
                    + "Events: Solo and group performances, DJ night, live band"
    };

    public EventsPage() {
        setLayout(new BorderLayout());
        setBackground(theme.bg);

        JLabel title = new JLabel("Events", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(theme.text);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(theme.bg);
        container.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        for (int i=0;i<Math.min(5, Data.events.size()); i++) {
            container.add(createEventButton(i));
        }

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(theme.bg);
        wrapper.add(container, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(wrapper);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createEventButton(int index) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(theme.bg);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        JButton button = new JButton(Data.events.get(index) + "   ▼");
        button.setFont(theme.text_font);
        button.setForeground(Color.BLACK);
        button.setBackground(theme.primary);
        button.setFocusPainted(false);
        button.setRolloverEnabled(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JTextArea description = new JTextArea(descriptions[index]);
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setForeground(theme.text);
        description.setBackground(theme.bg);
        description.setEditable(false);
        description.setFocusable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setVisible(false);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        button.addActionListener(new ActionListener() {

            private boolean expanded = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                expanded = !expanded;
                description.setVisible(expanded);

                if (expanded) {
                    button.setText(Data.events.get(index) + "   ▲");
                } else {
                    button.setText(Data.events.get(index) + "   ▼");
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
