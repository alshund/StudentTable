package strategy.algoritms.studentNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 01.05.2017.
 */
public class StudentFnSearch implements SearchStrategy {
    private String firstName;

    public StudentFnSearch(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        String studentFn = student.getFirstName();

        return firstName.equals(studentFn);
    }
}
