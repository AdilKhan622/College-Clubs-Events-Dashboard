package components;

import javax.swing.*;
import java.awt.*;
import main.MainFrame;
import main.Router;

public class SideMenu extends JPanel {

    public SideMenu(Router router) {

        setPreferredSize(new Dimension(200, 0));
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton dashboard = createButton("Dashboard");
        JButton clubs = createButton("Clubs");
        JButton events = createButton("Events");
        JButton reg = createButton("Registrations");
        JButton finance = createButton("Finance");

        add(dashboard);
        add(clubs);
        add(events);
        add(reg);
        add(finance);

        dashboard.addActionListener(e -> {
            Router.goTo("Dashboard", "Dashboard");
            MainFrame.instance.getHeaderPanel().setPageTitle("Dashboard");
        });

        clubs.addActionListener(e -> {
            Router.goTo("Clubs", "Clubs");
            MainFrame.instance.getHeaderPanel().setPageTitle("Clubs");
        });

        events.addActionListener(e -> {
            Router.goTo("Events", "Events");
            MainFrame.instance.getHeaderPanel().setPageTitle("Events");
        });

        reg.addActionListener(e -> {
            Router.goTo("Registrations", "Registrations");
            MainFrame.instance.getHeaderPanel().setPageTitle("Registrations");
        });

        finance.addActionListener(e -> {
            Router.goTo("Finance", "Finance");
            MainFrame.instance.getHeaderPanel().setPageTitle("Finance");
        });
    }

    private JButton createButton(String text) {

        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setOpaque(false);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setContentAreaFilled(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.YELLOW);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.WHITE);
            }
        });

        return btn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(
                0, 0, MainFrame.theme.sidebarGradientTop,
                0, getHeight(), MainFrame.theme.sidebarGradientBottom
        );

        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
