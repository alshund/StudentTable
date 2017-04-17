import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 12.04.2017.
 */
public class AddStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableView tableView;
    private StudentDataBase studentDataBase;

    public AddStudentListener(JFrame mainFrame, TableView tableView) {
        this.mainFrame = mainFrame;
        this.tableView = tableView;
        studentDataBase = new StudentDataBase();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        AdditionStudentDialog additionStudentDialog = new AdditionStudentDialog(mainFrame, tableView, studentDataBase);
    }


//    private void addDialogComponents() {
//        JButton addStudentDialogButton = new JButton("Confirm");
//        lConfirmAddition confirmAddition = new lConfirmAddition(additionStudentDialogPanel, tableView, studentDataBase);
//        addStudentDialogButton.addActionListener(confirmAddition);
//        addStudentDialog.add(additionStudentDialogPanel, BorderLayout.CENTER);
//        addStudentDialog.add(addStudentDialogButton, BorderLayout.SOUTH);
//        addStudentDialog.setResizable(false);
//
//    }
}
