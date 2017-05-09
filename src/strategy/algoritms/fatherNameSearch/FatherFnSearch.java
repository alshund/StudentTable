package strategy.algoritms.fatherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherFnSearch implements SearchStrategy {
    private String firstName;

    public FatherFnSearch(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        String fatherFn = student.getFather().getFirstName();

        return firstName.equals(fatherFn);
    }
}
