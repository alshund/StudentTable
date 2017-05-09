package strategy.algoritms.sisterAmountSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class SisterAmountSearch implements SearchStrategy {
    private Integer sisterAmount;

    public SisterAmountSearch(Integer sisterAmount) {
        this.sisterAmount = sisterAmount;
    }

    @Override
    public boolean execute(Student student) {
        Integer studentStAm = student.getSistersAmount();

        return sisterAmount == studentStAm;
    }
}
