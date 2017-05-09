package tableListener;

import studentTable.dialog.SearchStudentDialog;
import tableController.TableController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 20.04.2017.
 */
public class SearchStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableController tableController;

    public SearchStudentListener(JFrame mainFrame, TableController tableController){
        this.mainFrame = mainFrame;
        this.tableController = tableController;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        new SearchStudentDialog(mainFrame, tableController);
    }
}
