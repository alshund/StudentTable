package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Mother;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherSnPtSearch implements SearchStrategy {
    private String surname;
    private String patronymic;

    public MotherSnPtSearch(String surname, String patronymic) {
        this.surname = surname;
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        Mother mother = student.getMother();

        String motherSn = mother.getSurname();
        String motherPt = mother.getPatronymic();

        return surname.equals(motherSn) && patronymic.equals(motherPt);
    }
}
