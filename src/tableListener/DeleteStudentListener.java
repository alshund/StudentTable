package tableListener;

import studentTable.dialog.DeleteStudentDialog;
import tableController.TableController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 25.04.2017.
 */
public class DeleteStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableController tableController;

    public DeleteStudentListener(JFrame mainFrame, TableController tableController) {
        this.mainFrame = mainFrame;
        this.tableController = tableController;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        new DeleteStudentDialog(mainFrame, tableController);
    }
}
