package tableListener;

import studentTable.AdditionStudentDialog;
import studentTable.TableWithPaging;
import tableController.TableController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 12.04.2017.
 */
public class AdditionStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableController tableController;

    public AdditionStudentListener(JFrame mainFrame, TableController tableController) {
        this.mainFrame = mainFrame;
        this.tableController = tableController;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        new AdditionStudentDialog(mainFrame, tableController);
    }
}
