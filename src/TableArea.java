import javax.swing.*;
import java.awt.*;

/**
 * Created by shund on 10.04.2017.
 */
public class TableArea extends JComponent {
    private TableModel tableModel;

    public TableArea(TableModel tableModel) {
        this.tableModel = tableModel;
        setLayout(new BorderLayout());
        add(addTableArea(), BorderLayout.NORTH);
    }

    private JPanel addTableArea() {
        JPanel table = new JPanel();
        table.setLayout(new GridBagLayout());
        addComponent(table, "ФИО студента", 0, 0, 1, 1);
        addComponent(table, "ФИО отца", 1, 0, 1, 1);
        addComponent(table, "Зарплата отца", 2, 0, 1, 1);
        addComponent(table, "ФИО матери", 3, 0, 1, 1);
        addComponent(table, "Зарплата матери", 4, 0, 1, 1);
        addComponent(table, "Число братьев", 5, 0, 1, 1);
        addComponent(table, "Число сестер", 6, 0, 1, 1);
        return table;
    }

    private void addComponent(JPanel container, String name, int gridx, int gridy, int gridwidth, int gridheight){
        JLabel label = new JLabel(name);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label.setHorizontalAlignment(JLabel.CENTER);
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                                                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                                        insets, 0, 0);
        container.add(label, gbc);
    }



}
