package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentSnSearch implements SearchStrategy {
    private String surname;

    public StudentSnSearch(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean execute(Student student) {
        String studentSn = student.getSurname();

        return surname.equals(studentSn);
    }
}
