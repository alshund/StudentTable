package selectStrategy.algoritms;

import selectStrategy.DataReader;
import selectStrategy.SelectStrategy;
import strategy.SearchStrategy;
import strategy.algoritms.studentNameSearch.*;
import studentTable.SearchPanel;

/**
 * Created by shund on 03.05.2017.
 */
public class StudentNameSelect implements SelectStrategy {
    private DataReader dataReader;

    public StudentNameSelect(SearchPanel searchPanel) {
        dataReader = new DataReader(searchPanel);
    }

    @Override
    public SearchStrategy execute() {
        if (dataReader.isValid(SearchPanel.STUDENT_SURNAME, SearchPanel.STUDENT_FIRST_NAME, SearchPanel.STUDENT_PATRONYMIC)) {
            if (isSurnameFirstNamePatronymic()) {
                return new StudentSnFnPtSearch(getSurname(), getFirstName(), getPatronymic());
            } else if (isSurnameFirstName()) {
                return new StudentSnFnSearch(getSurname(), getFirstName());
            } else if (isSurnamePatronymic()) {
                return new StudentSnPtSearch(getSurname(), getPatronymic());
            } else if (isFirstNamePatronymic()) {
                return new StudentFnPtSearch(getFirstName(), getPatronymic());
            } else if (isSurname()) {
                return new StudentSnSearch(getSurname());
            } else if (isFirstName()) {
                return new StudentFnSearch(getFirstName());
            } else if (isPatronymic()) {
                return new StudentPtSearch(getPatronymic());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    private String getSurname() {
        return dataReader.getText(SearchPanel.STUDENT_SURNAME);
    }

    private String getFirstName() {
        return dataReader.getText(SearchPanel.STUDENT_FIRST_NAME);
    }

    private String getPatronymic() {
        return dataReader.getText(SearchPanel.STUDENT_PATRONYMIC);
    }

    private boolean isSurnameFirstNamePatronymic() {
        return dataReader.isThree(SearchPanel.STUDENT_SURNAME, SearchPanel.STUDENT_FIRST_NAME, SearchPanel.STUDENT_PATRONYMIC);
    }

    private boolean isSurnameFirstName() {
        return dataReader.isTwo(SearchPanel.STUDENT_SURNAME, SearchPanel.STUDENT_FIRST_NAME);
    }

    private boolean isSurnamePatronymic() {
        return dataReader.isTwo(SearchPanel.STUDENT_SURNAME, SearchPanel.STUDENT_PATRONYMIC);
    }

    private boolean isFirstNamePatronymic() {
        return dataReader.isTwo(SearchPanel.STUDENT_FIRST_NAME, SearchPanel.STUDENT_PATRONYMIC);
    }

    private boolean isSurname() {
        return dataReader.isOne(SearchPanel.STUDENT_SURNAME);
    }

    private boolean isFirstName() {
        return dataReader.isOne(SearchPanel.STUDENT_FIRST_NAME);
    }

    private boolean isPatronymic() {
        return dataReader.isOne(SearchPanel.STUDENT_PATRONYMIC);
    }
}