import java.util.ArrayList;
import java.util.List;

/**
 * Created by shund on 09.04.2017.
 */
public class TableModel {
    private List<Student> students;

    public TableModel() {
        students = new ArrayList<Student>();
    }

    public List getStudents() {
        return students;
    }
}
