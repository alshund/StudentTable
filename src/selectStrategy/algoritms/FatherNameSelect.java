package selectStrategy.algoritms;

import selectStrategy.DataReader;
import selectStrategy.SelectStrategy;
import strategy.SearchStrategy;
import strategy.algoritms.fatherNameSearch.*;
import studentTable.SearchPanel;

/**
 * Created by shund on 03.05.2017.
 */
public class FatherNameSelect implements SelectStrategy {
    private DataReader dataReader;

    public FatherNameSelect(SearchPanel searchPanel) {
        dataReader = new DataReader(searchPanel);
    }

    @Override
    public SearchStrategy execute() {
        if (dataReader.isValid(SearchPanel.PARENT_SURNAME, SearchPanel.PARENT_FIRST_NAME, SearchPanel.PARENT_PATRONYMIC)) {
            if (isSurnameFirstNamePatronymic()) {
                return new FatherSnFnPtSearch(getSurname(), getFirstName(), getPatronymic());
            } else if (isSurnameFirstName()) {
                return new FatherSnFnSearch(getSurname(), getFirstName());
            } else if (isSurnamePatronymic()) {
                return new FatherSnPtSearch(getSurname(), getPatronymic());
            } else if (isFirstNamePatronymic()) {
                return new FatherFnPtSearch(getFirstName(), getPatronymic());
            } else if (isSurname()) {
                return new FatherSnSearch(getSurname());
            } else if (isFirstName()) {
                return new FatherFnSearch(getFirstName());
            } else if (isPatronymic()) {
                return new FatherPtSearch(getPatronymic());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private String getSurname() {
        return dataReader.getText(SearchPanel.PARENT_SURNAME);
    }

    private String getFirstName() {
        return dataReader.getText(SearchPanel.PARENT_FIRST_NAME);
    }

    private String getPatronymic() {
        return dataReader.getText(SearchPanel.PARENT_PATRONYMIC);
    }

    private boolean isSurnameFirstNamePatronymic() {
        return dataReader.isThree(SearchPanel.PARENT_SURNAME, SearchPanel.PARENT_FIRST_NAME, SearchPanel.PARENT_PATRONYMIC);
    }

    private boolean isSurnameFirstName() {
        return dataReader.isTwo(SearchPanel.PARENT_SURNAME, SearchPanel.PARENT_FIRST_NAME);
    }

    private boolean isSurnamePatronymic() {
        return dataReader.isTwo(SearchPanel.PARENT_SURNAME, SearchPanel.PARENT_PATRONYMIC);
    }

    private boolean isFirstNamePatronymic() {
        return dataReader.isTwo(SearchPanel.PARENT_FIRST_NAME, SearchPanel.PARENT_PATRONYMIC);
    }

    private boolean isSurname() {
        return dataReader.isOne(SearchPanel.PARENT_SURNAME);
    }

    private boolean isFirstName() {
        return dataReader.isOne(SearchPanel.PARENT_FIRST_NAME);
    }

    private boolean isPatronymic() {
        return dataReader.isOne(SearchPanel.PARENT_PATRONYMIC);
    }
}