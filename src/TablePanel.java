import javax.swing.*;
import java.awt.*;

/**
 * Created by shund on 11.04.2017.
 */
public class TablePanel extends JPanel {
    public static final int TEXT_FIELD_SIZE = 5;
    private TableArea tableArea;

    public TablePanel(TableArea tableArea) {
        this.tableArea = tableArea;
        setLayout(new GridBagLayout());
        addComponents();
    }

    private void addComponents() {
        JTextField numberOfRecordsField = new JTextField("10", TEXT_FIELD_SIZE);
        JButton firstPageButton = new JButton("Begin");
        JButton lastPageButton = new JButton("End");
        JButton previousPageButton = new JButton("Previous");
        JButton nextPageButton = new JButton("Next");
        addComponent(numberOfRecordsField, 0, 0, 1, 1);
        addComponent(firstPageButton, 1, 0, 1, 1);
        addComponent(previousPageButton, 2, 0, 1, 1);
        addComponent(nextPageButton, 3, 0, 1, 1);
        addComponent(lastPageButton, 4, 0, 1, 1);
//        add(numberOfRecordsField, FlowLayout.RIGHT);
//        add(nextPageButton, FlowLayout.RIGHT);
//        add(firstPageButton, FlowLayout.RIGHT);
//        add(previousPageButton, FlowLayout.RIGHT);
//        add(nextPageButton, FlowLayout.RIGHT);
//        add(lastPageButton, FlowLayout.RIGHT);

    }
    /*
    *      * * * * *
    * */

    private void addComponent(JComponent component, int gridX, int gridY, int gridWidth, int gridHeight) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 0.0,
                                                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                                        insets, 0, 0);
        add(component, gbc);
    }
}
