import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 12.04.2017.
 */
public class AddStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableArea tableArea;
    private JDialog addStudentDialogFrame;

    public AddStudentListener(JFrame mainFrame, TableView tableView) {
        this.mainFrame = mainFrame;
        this.tableArea = tableView.getTableArea();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        addDialog();
        AddStudentDialogPanel addStudentDialogPanel = new AddStudentDialogPanel(tableArea);
        addStudentDialogFrame.add(addStudentDialogPanel, BorderLayout.NORTH);
        addStudentDialogFrame.setResizable(false);
    }

    private void addDialog() {
        addStudentDialogFrame = new JDialog(mainFrame, "Add new student", false);
        addStudentDialogFrame.setSize(600, 328);
        addStudentDialogFrame.setLayout(new BorderLayout());
        addStudentDialogFrame.setLocationRelativeTo(tableArea);
        addStudentDialogFrame.setVisible(true);
    }
}
