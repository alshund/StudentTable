import javax.swing.*;
import java.awt.*;

/**
 * Created by shund on 11.04.2017.
 */
public class TablePanel extends JComponent {
    private TableArea tableArea;

    public TablePanel(TableArea tableArea) {
        this.tableArea = tableArea;
        setLayout(new BorderLayout());
    }

    private JPanel addTablePanel() {
        JPanel tablePanel = new JPanel();
        return tablePanel;
    }
}
