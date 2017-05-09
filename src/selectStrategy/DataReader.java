package selectStrategy;

import studentTable.dialog.SearchPanel;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * Created by shund on 08.05.2017.
 */
public class DataReader {
    private SearchPanel searchPanel;

    public DataReader(SearchPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public String getText(int readableField) {
        String firstName = ((JTextField) searchPanel.getInputList().get(readableField)).getText();
        return firstName;
    }

    public Number getNumber(int readableField) {
        Number firstNumber = (Number) ((JSpinner) searchPanel.getInputList().get(readableField)).getValue();
        return firstNumber;
    }

    public boolean isThree(int firstCheckBox, int secondCheckBox, int thirdCheckBox) {
        boolean firstParameter = searchPanel.getCheckBoxFieldList().get(firstCheckBox).isSelected();
        boolean secondParameter = searchPanel.getCheckBoxFieldList().get(secondCheckBox).isSelected();
        boolean thirdParameter = searchPanel.getCheckBoxFieldList().get(thirdCheckBox).isSelected();

        return firstParameter && secondParameter && thirdParameter;
    }

    public boolean isTwo(int firstCheckBox, int secondCheckBox) {
        boolean firstParameter = searchPanel.getCheckBoxFieldList().get(firstCheckBox).isSelected();
        boolean secondParameter = searchPanel.getCheckBoxFieldList().get(secondCheckBox).isSelected();

        return firstParameter && secondParameter;
    }

    public boolean isOne(int firstCheckBox){
        boolean firstParameter = searchPanel.getCheckBoxFieldList().get(firstCheckBox).isSelected();

        return firstParameter;
    }

    public boolean isValid(int surname, int firstName, int patronymic) {
        boolean isValid = true;
        Pattern nameField = Pattern.compile("([А-Я])[а-я]+");
        JTextField tfSurname = (JTextField) searchPanel.getInputList().get(surname);
        JTextField tfFirstName = (JTextField) searchPanel.getInputList().get(firstName);
        JTextField tfPatronymic = (JTextField) searchPanel.getInputList().get(patronymic);
        if (!isOne(surname) && !isOne(firstName) && !isOne(patronymic)) {
            isValid = false;
            JOptionPane.showMessageDialog(searchPanel.getSearchPanel(), "Select the search parameter", "Parameter error", JOptionPane.ERROR_MESSAGE);
        } else if (!nameField.matcher(tfSurname.getText()).matches() && isOne(surname)) {
            isValid = false;
            showMassage(tfSurname, tfSurname.getName());
        } else if (!nameField.matcher(tfFirstName.getText()).matches() && isOne(firstName)) {
            isValid = false;
            showMassage(tfFirstName, tfFirstName.getName());
        } else if (!nameField.matcher(tfPatronymic.getText()).matches() && isOne(patronymic)) {
            isValid = false;
            showMassage(tfPatronymic, tfPatronymic.getName());
        }
        return isValid;
    }

    private void showMassage(JTextField textField, String mistakeName) {
        JOptionPane.showMessageDialog(searchPanel.getSearchPanel(), mistakeName + " was incorrectly entered!");
        textField.setText("");
        textField.requestFocus();
    }
}