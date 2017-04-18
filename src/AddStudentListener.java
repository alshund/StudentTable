import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 12.04.2017.
 */
public class AddStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableWithPaging tableWithPaging;
    private StudentDataBase studentDataBase;

    public AddStudentListener(JFrame mainFrame, TableWithPaging tableWithPaging) {
        this.mainFrame = mainFrame;
        this.tableWithPaging = tableWithPaging;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        AdditionStudentDialog additionStudentDialog = new AdditionStudentDialog(mainFrame, tableWithPaging);
    }


//    private void addDialogComponents() {
//        JButton addStudentDialogButton = new JButton("Confirm");
//        lConfirmAddition confirmAddition = new lConfirmAddition(additionStudentDialogPanel, tableWithPaging, studentDataBase);
//        addStudentDialogButton.addActionListener(confirmAddition);
//        addStudentDialog.add(additionStudentDialogPanel, BorderLayout.CENTER);
//        addStudentDialog.add(addStudentDialogButton, BorderLayout.SOUTH);
//        addStudentDialog.setResizable(false);
//
//    }
}
