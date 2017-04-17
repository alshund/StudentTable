import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by shund on 10.04.2017.
 */
public class TableArea extends JTable {
    private TableModel tableModel;
    private List<Student> students;
    private int pageNumber;

    public TableArea(TableModel tableModel) {
        super(tableModel);
        this.tableModel = tableModel;
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
        TableModel tableModel = new TableModel(students);
        this.setModel(tableModel);
    }

    public void goToPage(int newPageNumber) {
        int listPosition = (pageNumber - 1);
    }


}
