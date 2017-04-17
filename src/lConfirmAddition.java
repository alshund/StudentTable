import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by shund on 13.04.2017.
 */
public class lConfirmAddition implements ActionListener {
    private AdditionStudentDialog dialogPanel;
    private TableView tableView;
    private StudentDataBase studentDataBase;

    public lConfirmAddition(AdditionStudentDialog dialogPanel, TableView tableView, StudentDataBase studentDataBase) {
        this.dialogPanel = dialogPanel;
        this.tableView = tableView;
        this.studentDataBase = studentDataBase;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
//        studentDataBase.addStudent(readStudent());
        tableView.getTableArea().addStudent(studentDataBase.getStudents().get(0));

    }



}
