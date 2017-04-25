package tableController;

import studentDataBase.Student;
import studentDataBase.StudentDataBase;
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
    JToolBar toolBar;
    TableWithPaging tableWithPaging;

    public NewTableListener(JToolBar toolBar, TableWithPaging tableWithPaging) {
        this.toolBar = toolBar;
        this.tableWithPaging = tableWithPaging;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        toolBar.setVisible(true);

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
