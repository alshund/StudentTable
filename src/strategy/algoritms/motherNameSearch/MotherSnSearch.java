package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Mother;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherSnSearch implements SearchStrategy {
    private String surname;

    public MotherSnSearch(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean execute(Student student) {
        String motherSn = student.getMother().getSurname();

        return surname.equals(motherSn);
    }
}
