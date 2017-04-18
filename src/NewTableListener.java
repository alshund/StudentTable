import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by shund on 10.04.2017.
 */
public class NewTableListener implements ActionListener {
    JFrame mainFrame;
    JMenuBar menuBar;
    JToolBar toolBar;
    TableWithPaging tableWithPaging;

    public NewTableListener(JFrame mainFrame, JMenuBar menuBar, JToolBar toolBar) {
        this.mainFrame = mainFrame;
        this.menuBar = menuBar;
        this.toolBar = toolBar;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        toolBar.setVisible(true);
        tableWithPaging = new TableWithPaging();
        mainFrame.add(tableWithPaging, BorderLayout.CENTER);
//        TableModel tableModel = new TableModel(new ArrayList<Student>());
//        TablePanel tablePanel = new TablePanel(tableArea);
//        tableWithPaging.setTableArea(tableArea);
//        tableWithPaging.setTablePanel(tablePanel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        tableWithPaging.add(scrollPane, BorderLayout.CENTER);
//        tableWithPaging.add(tablePanel, BorderLayout.SOUTH);
        addListener();
    }

    private void addListener() {
        AddStudentListener addStudentListener = new AddStudentListener(mainFrame, tableWithPaging);
        menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.ADD_EDIT).addActionListener(addStudentListener);
    }
}
