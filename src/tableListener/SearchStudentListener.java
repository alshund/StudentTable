package tableListener;

import studentTable.SearchStudentDialog;
import studentTable.TableWithPaging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 20.04.2017.
 */
public class SearchStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableWithPaging tableWithPaging;

    public SearchStudentListener(JFrame mainFrame, TableWithPaging tableWithPaging){
        this.mainFrame = mainFrame;
        this.tableWithPaging = tableWithPaging;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        SearchStudentDialog searchStudentDialog = new SearchStudentDialog(mainFrame, tableWithPaging);
    }
}
