package strategy.algoritms.motherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class MotherLwSearch implements SearchStrategy {
    private Double lowerLimit;

    public MotherLwSearch(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double motherSalary = student.getMother().getSalary();

        return lowerLimit <= motherSalary;
    }
}