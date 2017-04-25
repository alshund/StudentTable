import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 12.04.2017.
 */
public class AdditionStudentListener implements ActionListener {
    private JFrame mainFrame;
    private TableWithPaging tableWithPaging;
    AdditionStudentDialog additionStudentDialog;

    public AdditionStudentListener(JFrame mainFrame, TableWithPaging tableWithPaging) {
        this.mainFrame = mainFrame;
        this.tableWithPaging = tableWithPaging;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        additionStudentDialog = new AdditionStudentDialog(mainFrame, tableWithPaging);
    }
}
