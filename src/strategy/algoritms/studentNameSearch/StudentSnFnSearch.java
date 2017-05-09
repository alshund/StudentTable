package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentSnFnSearch implements SearchStrategy {
    private String surname;
    private String firstName;

    public StudentSnFnSearch(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        String studentSn = student.getSurname();
        String studentFn = student.getFirstName();

        return surname.equals(studentSn) && firstName.equals(studentFn);
    }
}
