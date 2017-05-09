package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentSnFnPtSearch implements SearchStrategy {
    private String surname;
    private String firstName;
    private String patronymic;

    public StudentSnFnPtSearch(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        String studentSn = student.getSurname();
        String studentFn = student.getFirstName();
        String studentPt = student.getPatronymic();

        return surname.equals(studentSn) && firstName.equals(studentFn) && patronymic.equals(studentPt);
    }
}
