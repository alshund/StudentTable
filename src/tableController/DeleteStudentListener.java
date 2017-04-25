package tableController;

import studentTable.DeleteStudentDialog;
import studentTable.TableWithPaging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 25.04.2017.
 */
public class DeleteStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableWithPaging tableWithPaging;
    DeleteStudentDialog deleteStudentDialog;

    public DeleteStudentListener(JFrame mainFrame, TableWithPaging tableWithPaging) {
        this.mainFrame = mainFrame;
        this.tableWithPaging = tableWithPaging;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        deleteStudentDialog = new DeleteStudentDialog(mainFrame, tableWithPaging);
    }
}
