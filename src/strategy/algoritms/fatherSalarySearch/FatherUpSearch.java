package strategy.algoritms.fatherSalarySearch;

import strategy.SearchStrategy;
import studentDataBase.Student;

/**
 * Created by shund on 08.05.2017.
 */
public class FatherUpSearch implements SearchStrategy {
    private Double upperLimit;

    public FatherUpSearch(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean execute(Student student) {
        Double fatherSalary = student.getFather().getSalary();

        return fatherSalary <= upperLimit;
    }
}