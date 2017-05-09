package strategy.algoritms.motherNameSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherPtSearch implements SearchStrategy {
    private String patronymic;

    public MotherPtSearch(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean execute(Student student) {
        String motherPt = student.getMother().getSurname();

        return patronymic.equals(motherPt);
    }
}
