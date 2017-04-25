package studentTable;

import studentDataBase.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by shund on 09.04.2017.
 */
public class TableModel extends AbstractTableModel {
    static public final int COLUMN_COUNT = 7;

    private List<Student> students;

    public TableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return students.get(rowIndex).getField(columnIndex);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        student.setField(columnIndex, aValue);
    }

    @Override
    public String getColumnName(int column) {
        String columnName[] = {"ФИО студента",
                "ФИО отца",
                "Зарплата отца",
                "ФИО матери",
                "Зарплата матери",
                "Количество братьев",
                "Количество сестер"};
        return columnName[column];
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
