package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherFnSearch implements SearchStrategy {
    private String firstName;

    public MotherFnSearch(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        String motherFn = student.getMother().getFirstName();

        return firstName.equals(motherFn);
    }
}
