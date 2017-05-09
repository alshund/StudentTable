package selectStrategy.algoritms;

import selectStrategy.DataReader;
import selectStrategy.SelectStrategy;
import strategy.SearchStrategy;
import strategy.algoritms.brotherAmountSearch.BrotherAmountSearch;
import studentTable.SearchPanel;

/**
 * Created by shund on 03.05.2017.
 */
public class BrotherAmountSelect implements SelectStrategy {
    private DataReader dataReader;

    public BrotherAmountSelect(SearchPanel searchPanel) {
        dataReader = new DataReader(searchPanel);
    }

    @Override
    public SearchStrategy execute( ) {
        return new BrotherAmountSearch(getBrotherAmount());
    }

    private Integer getBrotherAmount() {
        return (Integer) dataReader.getNumber(SearchPanel.SIBLING_AMOUNT);
    }
}
