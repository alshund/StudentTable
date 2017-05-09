package strategy.algoritms.fatherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Father;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherSnFnSearch implements SearchStrategy {
    private String surname;
    private String firstName;

    public FatherSnFnSearch(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        Father father = student.getFather();

        String fatherSn = father.getSurname();
        String fatherFn = father.getFirstName();

        return surname.equals(fatherSn) && firstName.equals(fatherFn);
    }
}
