import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by shund on 10.04.2017.
 */
public class NewTableListener implements ActionListener {
    JToolBar toolBar;
    TableView tableView;

    public NewTableListener(JToolBar toolBar, TableView tableView) {
        this.toolBar = toolBar;
        this.tableView = tableView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        toolBar.setVisible(true);
        TableModel tableModel = new TableModel(new ArrayList<Student>());
        TableArea tableArea = new TableArea(tableModel);
        TablePanel tablePanel = new TablePanel(tableArea);
        tableView.setTableArea(tableArea);
        tableView.setTablePanel(tablePanel);
        JScrollPane scrollPane = new JScrollPane(tableArea);
        tableView.add(scrollPane, BorderLayout.CENTER);
        tableView.add(tablePanel, BorderLayout.SOUTH);
    }
}
