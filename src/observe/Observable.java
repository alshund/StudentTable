package observe;

import studentDataBase.Student;

import java.util.List;

/**
 * Created by shund on 07.05.2017.
 */
public interface Observable {
    void addTable(Observer observer);
    void removeTable(Observer observer);
    void repaintPaging();
    void refreshPaging();
    void updateData(List<Student> page);
    void createModel();
}
