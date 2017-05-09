package strategy.algoritms.brotherAmountSearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class BrotherAmountSearch implements SearchStrategy {
    private Integer brotherAmount;

    public BrotherAmountSearch(Integer brotherAmount) {
        this.brotherAmount = brotherAmount;
    }

    @Override
    public boolean execute(Student student) {
        Integer studentBrAm = student.getBrothersAmount();

        return brotherAmount == studentBrAm;
    }
}
