package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentFnPtSearch implements SearchStrategy {
    private String firstName;
    private String patronymic;

    public StudentFnPtSearch(String firstName, String patronymic) {
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        String studentFn = student.getFirstName();
        String studentPt = student.getPatronymic();

        return firstName.equals(studentFn) && patronymic.equals(studentPt);
    }
}
