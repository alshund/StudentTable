package selectStrategy.algoritms;

import selectStrategy.DataReader;
import selectStrategy.SelectStrategy;
import strategy.SearchStrategy;
import strategy.algoritms.motherSalarySearch.MotherLwSearch;
import strategy.algoritms.motherSalarySearch.MotherLwUpSearch;
import strategy.algoritms.motherSalarySearch.MotherUpSearch;
import studentTable.SearchPanel;

/**
 * Created by shund on 03.05.2017.
 */
public class MotherSalarySelect implements SelectStrategy {
    private DataReader dataReader;

    public MotherSalarySelect(SearchPanel searchPanel) {
        dataReader = new DataReader(searchPanel);
    }

    @Override
    public SearchStrategy execute() {
        if (isLowerUpperLimit()) {
            return new MotherLwUpSearch(getLowerLimit(), getUpperLimit());
        } else if (isLowerLimit()) {
            return new MotherLwSearch(getLowerLimit());
        } else if (isUpperLimit()) {
            return new MotherUpSearch(getUpperLimit());
        }  else {
            return null;
        }
    }

    private Double getLowerLimit() {
        return (Double) dataReader.getNumber(SearchPanel.SALARY_LOWER_LIMIT);
    }

    private Double getUpperLimit() {
        return (Double) dataReader.getNumber(SearchPanel.SALARY_UPPER_LIMIT);
    }

    private boolean isLowerUpperLimit() {
        return dataReader.isTwo(SearchPanel.SALARY_LOWER_LIMIT, SearchPanel.SALARY_UPPER_LIMIT);
    }

    private boolean isLowerLimit() {
        return dataReader.isOne(SearchPanel.SALARY_LOWER_LIMIT);
    }

    private boolean isUpperLimit() {
        return dataReader.isOne(SearchPanel.SALARY_UPPER_LIMIT);
    }
}
