package tableController;

import strategy.SearchStrategy;
import studentDataBase.Student;
import studentDataBase.StudentDataBase;
import studentTable.TableWithPaging;

import javax.swing.text.TabableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shund on 30.04.2017.
 */
public class TableController {
    private StudentDataBase studentDataBase;

    public TableController(StudentDataBase studentDataBase) {
        this.studentDataBase = studentDataBase;
    }

    public void changeRecodesAmount() {
        studentDataBase.changeRecodesAmount();
    }

    public void changePage(int currentPage, int recodesAmount) {
        studentDataBase.changePage(currentPage, recodesAmount);
    }

    public void addStudent(Student student) {
        studentDataBase.addStudent(student);
    }

    public List<Student> search() {
        return studentDataBase.search();
    }

    public void delete() {
        studentDataBase.delete();
    }

    public int getDataBaseSize() {
        return studentDataBase.getDataBaseSize();
    }

    public StudentDataBase getStudentDataBase() {
        return studentDataBase;
    }

    public void setStudentDataBase(StudentDataBase studentDataBase) {
        this.studentDataBase = studentDataBase;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        studentDataBase.setSearchStrategy(searchStrategy);
    }

    public SearchStrategy getSearchStrategy() {
        return studentDataBase.getSearchStrategy();
    }
}
