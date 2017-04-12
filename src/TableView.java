import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by shund on 11.04.2017.
 */
public class TableView extends JComponent {
    private TableArea tableArea;
    private TablePanel tablePanel;

    public TableView() {
        setLayout(new BorderLayout());
    }

    public TableArea getTableArea() {
        return tableArea;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public void setTableArea(TableArea tableArea) {
        this.tableArea = tableArea;
    }

    public void setTablePanel(TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }
}
