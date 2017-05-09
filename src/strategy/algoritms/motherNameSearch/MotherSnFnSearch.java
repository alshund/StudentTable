package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Mother;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherSnFnSearch implements SearchStrategy {
    private String surname;
    private String firstName;

    public MotherSnFnSearch(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    @Override
    public boolean execute(Student student) {
        Mother mother = student.getMother();

        String motherSn = mother.getSurname();
        String motherFn = mother.getFirstName();

        return surname.equals(motherSn) && firstName.equals(motherFn);
    }
}
