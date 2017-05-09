package strategy;

import studentDataBase.Student;

import java.util.List;

/**
 * Created by shund on 01.05.2017.
 */
public interface SearchStrategy {
    boolean execute(Student student);
}
