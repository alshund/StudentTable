package tableListener;

import studentDataBase.Student;
import studentDataBase.StudentDataBase;
import studentTable.MainWindow;
import studentTable.TableModel;
import studentTable.TableWithPaging;
import tableController.TableController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by shund on 10.04.2017.
 */
public class NewTableListener implements ActionListener {
    JMenuBar menuBar;
    JToolBar toolBar;
    TableWithPaging tableWithPaging;
    TableController tableController;

    public NewTableListener(JMenuBar menuBar, JToolBar toolBar, TableWithPaging tableWithPaging, TableController tableController) {
        this.menuBar = menuBar;
        this.toolBar = toolBar;
        this.tableWithPaging = tableWithPaging;
        this.tableController = tableController;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!toolBar.isVisible()) {
            toolBar.setVisible(true);

            menuBar.getMenu(MainWindow.FILE_MENU).getItem(MainWindow.SAVE_FILE).setEnabled(true);

            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.ADD_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.SEARCH_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.DELETE_EDIT).setEnabled(true);
        }

        TableModel tableModel = new TableModel(new ArrayList<Student>());
        tableWithPaging.setTableModel(tableModel);

        tableController.getStudentDataBase().setStudents(new ArrayList<Student>());



        tableWithPaging.getToolBar().setVisible(true);
//        tableController.getStudentDataBase().addTable(tableWithPaging);
    }
}
