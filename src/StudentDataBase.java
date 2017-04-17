import java.util.ArrayList;
import java.util.List;

/**
 * Created by shund on 13.04.2017.
 */
public class StudentDataBase {
    private List<Student> students;

    public StudentDataBase() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
