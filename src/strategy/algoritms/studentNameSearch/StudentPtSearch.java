package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentPtSearch implements SearchStrategy {
    private String patronymic;

    public StudentPtSearch(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        String studentPt = student.getPatronymic();

        return patronymic.equals(studentPt);
    }
}
