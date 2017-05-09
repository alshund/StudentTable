package strategy.algoritms.motherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherLwUpSearch implements SearchStrategy {
    private Double lowerLimit;
    private Double upperLimit;

    public MotherLwUpSearch(Double lowerLimit, Double upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double motherSalary = student.getMother().getSalary();

        return lowerLimit <= motherSalary && motherSalary <= upperLimit;
    }
}