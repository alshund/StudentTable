package tableController;

import studentDataBase.Student;
import studentDataBase.StudentDataBase;
import studentTable.MainWindow;
import studentTable.TableModel;
import studentTable.TableWithPaging;

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

    public NewTableListener(JMenuBar menuBar, JToolBar toolBar, TableWithPaging tableWithPaging) {
        this.menuBar = menuBar;
        this.toolBar = toolBar;
        this.tableWithPaging = tableWithPaging;
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

        StudentDataBase studentDataBase = new StudentDataBase();
        tableWithPaging.setStudentDataBase(studentDataBase);

        tableWithPaging.setRecodesNumber(5);
        tableWithPaging.setPagesNumber(1);
        tableWithPaging.setCurrentPage(1);

        tableWithPaging.getToolBar().setVisible(true);
    }
}
