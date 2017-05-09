package strategy.algoritms.fatherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherLwSearch implements SearchStrategy {
    private Double lowerLimit;

    public FatherLwSearch(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double fatherSalary = student.getFather().getSalary();

        return lowerLimit <= fatherSalary;
    }
}