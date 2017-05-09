package observe;

import studentDataBase.Student;

import java.util.List;

/**
 * Created by shund on 07.05.2017.
 */
public interface Observer {
    void repaintPaging(int dataBaseSize);
    void refreshPaging(int dataBaseSize);
    void updateData(List<Student> page);
    void createModel();
}
