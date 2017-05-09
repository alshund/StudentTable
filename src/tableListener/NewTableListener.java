package tableListener;

import constants.Window;
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

            menuBar.getMenu(Window.FILE_MENU).getItem(Window.SAVE_FILE).setEnabled(true);

            menuBar.getMenu(Window.EDIT_MENU).getItem(Window.ADD_EDIT).setEnabled(true);
            menuBar.getMenu(Window.EDIT_MENU).getItem(Window.SEARCH_EDIT).setEnabled(true);
            menuBar.getMenu(Window.EDIT_MENU).getItem(Window.DELETE_EDIT).setEnabled(true);
        }

        TableModel tableModel = new TableModel(new ArrayList<Student>());
        tableWithPaging.setTableModel(tableModel);

        tableController.getStudentDataBase().setStudents(new ArrayList<Student>());



        tableWithPaging.getToolBar().setVisible(true);
//        tableController.getStudentDataBase().addTable(tableWithPaging);
    }
}
