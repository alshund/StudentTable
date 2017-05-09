package strategy.algoritms.fatherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Father;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherLwUpSearch implements SearchStrategy {
    private Double lowerLimit;
    private Double upperLimit;

    public FatherLwUpSearch(Double lowerLimit, Double upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double fatherSalary = student.getFather().getSalary();

        return lowerLimit <= fatherSalary && fatherSalary <= upperLimit;
    }
}