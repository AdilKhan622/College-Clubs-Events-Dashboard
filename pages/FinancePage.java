package pages;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import main.MainFrame;

public class FinancePage extends JPanel {

    public FinancePage() {
        setLayout(new BorderLayout());
        setBackground(MainFrame.theme.bg);
        setBorder(BorderFactory.createEmptyBorder(
                MainFrame.theme.padding,
                MainFrame.theme.padding,
                MainFrame.theme.padding,
                MainFrame.theme.padding));

        JLabel titleLabel = new JLabel("Club Finances");
        titleLabel.setFont(MainFrame.theme.subtitle_Font);
        titleLabel.setForeground(MainFrame.theme.text);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        summaryPanel.setBackground(MainFrame.theme.bg);
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        summaryPanel.add(createFinanceCard("Total Budget", "₹50,000", MainFrame.theme.text));
        summaryPanel.add(createFinanceCard("Expenses", "₹25,000", MainFrame.theme.text));
        summaryPanel.add(createFinanceCard("Remaining", "₹25,000", MainFrame.theme.text));

        String[] columnNames = { "Date", "Club", "Description", "Amount", "Type" };
        Object[][] data = {
                { "2024-01-10", "MU Robotics Club", "Event Supplies", "₹5,000", "Expense" },
                { "2024-01-12", "Enigma MU", "Workshop", "₹3,000", "Expense" },
                { "2024-01-15", "8Counts", "Sponsorship", "₹10,000", "Income" }
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
        header.setBackground(MainFrame.theme.primary);
        header.setForeground(Color.WHITE);
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
        topPanel.add(summaryPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createFinanceCard(String title, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(MainFrame.theme.primary);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MainFrame.theme.primary, 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)));

        JPanel accentPanel = new JPanel();
        accentPanel.setBackground(color);
        accentPanel.setPreferredSize(new Dimension(6, 0));
        card.add(accentPanel, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(new BorderLayout(0, 12));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(MainFrame.theme.text_font);
        titleLabel.setForeground(MainFrame.theme.text);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font(
                MainFrame.theme.title_font.getName(),
                Font.BOLD,
                28));
        valueLabel.setForeground(color);

        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(valueLabel, BorderLayout.CENTER);

        card.add(contentPanel, BorderLayout.CENTER);
        return card;
    }
}
