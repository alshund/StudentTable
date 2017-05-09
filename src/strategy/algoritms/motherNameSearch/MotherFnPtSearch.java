package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Mother;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherFnPtSearch implements SearchStrategy {
    private String firstName;
    private String patronymic;

    public MotherFnPtSearch(String firstName, String patronymic) {
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        Mother mother = student.getMother();

        String motherFn = mother.getFirstName();
        String motherPt = mother.getPatronymic();

        return firstName.equals(motherFn) && patronymic.equals(motherPt);
    }
}
