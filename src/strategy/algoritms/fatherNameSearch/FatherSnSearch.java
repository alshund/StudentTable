package strategy.algoritms.fatherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherSnSearch implements SearchStrategy {
    private String surname;

    public FatherSnSearch(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean execute(Student student) {
        String fatherSn = student.getFather().getSurname();

        return surname.equals(fatherSn);
    }
}
