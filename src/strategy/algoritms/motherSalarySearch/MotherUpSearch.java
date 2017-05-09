package strategy.algoritms.motherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherUpSearch implements SearchStrategy {
    private Double upperLimit;

    public MotherUpSearch(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double motherSalary = student.getMother().getSalary();

        return motherSalary <= upperLimit;
    }
}
