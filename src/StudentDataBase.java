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

    public List<Student> getPage(int currentPage, int recodesNumber) {
        List<Student> page = new ArrayList<Student>();
        int beginIndex = (currentPage - 1) * (recodesNumber);
        int endIndex = beginIndex + (recodesNumber);
        for (int studentIndex = beginIndex; studentIndex < endIndex; studentIndex++) {
            if (studentIndex >= students.size()){
                break;
            }
            page.add(students.get(studentIndex));
        }
        return page;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
