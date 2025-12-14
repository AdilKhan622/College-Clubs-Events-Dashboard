package pages;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import main.MainFrame;

public class RegistrationsPage extends JPanel {

    public RegistrationsPage() {
        setLayout(new BorderLayout());
        setBackground(MainFrame.theme.bg);
        setBorder(BorderFactory.createEmptyBorder(
                MainFrame.theme.padding,
                MainFrame.theme.padding,
                MainFrame.theme.padding,
                MainFrame.theme.padding));

        JLabel titleLabel = new JLabel("Event Registrations");
        titleLabel.setFont(MainFrame.theme.title_font);
        titleLabel.setForeground(MainFrame.theme.text);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

        String[] columnNames = { "Event Name", "Student Name", "Email", "Status", "Date" };
        Object[][] data = {
                { "Aeon MU", "John Doe", "john@gmail.com", "Confirmed", "2024-01-15" },
                { "Airo MU", "Jane Smith", "jane@gmail.com", "Pending", "2024-01-16" }
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setFont(MainFrame.theme.text_font);
        table.setRowHeight(40);
        table.setBackground(MainFrame.theme.primary);
        table.setGridColor(MainFrame.theme.tableColor);
        table.setShowGrid(true);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(MainFrame.theme.text_font);
        header.setPreferredSize(new Dimension(0, 45));
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setBackground(MainFrame.theme.primary);
                label.setForeground(Color.WHITE);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);

                return label;
            }
        });

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground(MainFrame.theme.primary);
                }

                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(MainFrame.theme.bg);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(MainFrame.theme.bg);
        topPanel.add(titleLabel, BorderLayout.NORTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
