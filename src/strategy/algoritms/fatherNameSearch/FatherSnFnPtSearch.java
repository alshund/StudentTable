package strategy.algoritms.fatherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Father;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherSnFnPtSearch implements SearchStrategy {
    private String surname;
    private String firstName;
    private String patronymic;

    public FatherSnFnPtSearch(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        Father father = student.getFather();

        String fatherSn = father.getSurname();
        String fatherFn = father.getFirstName();
        String fatherPt = father.getPatronymic();

        return surname.equals(fatherSn) && firstName.equals(fatherFn) && patronymic.equals(fatherPt);
    }
}
