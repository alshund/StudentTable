import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shund on 09.04.2017.
 */
public class TableModel extends AbstractTableModel {
    private final int COLUMN_COUNT = 7;

    private List<Student> students;
    private int recordsNumber;
    private int currentPage;

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

    public int getRecordsNumber() {
        return recordsNumber;
    }

    public void setRecordsNumber(int recordsNumber) {
        this.recordsNumber = recordsNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
