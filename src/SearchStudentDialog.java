import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by shund on 22.04.2017.
 */
public class SearchStudentDialog {
    private JDialog searchStudentDialog;
    private TableWithPaging searchTable;
    private SearchPanel searchPanel;
    private StudentDataBase studentDataBase;

    public SearchStudentDialog(JFrame mainFrame, TableWithPaging tableWithPaging) {
        studentDataBase = tableWithPaging.getStudentDataBase();

        searchStudentDialog = new JDialog(mainFrame, "Search student", true);
        searchStudentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        searchStudentDialog.setSize(1000, 650);
        searchStudentDialog.setLayout(new BorderLayout());
        searchStudentDialog.setLocationRelativeTo(tableWithPaging);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridBagLayout());

        searchPanel = new SearchPanel();
        addComponent(dialogPanel, searchPanel.getSearchPanel(), 0, 0, 1);

        searchTable = new TableWithPaging();
        searchTable.setCurrentPage(1);
        searchTable.setPagesNumber(1);
        searchTable.setRecodesNumber(5);
        searchTable.setStudentDataBase(new StudentDataBase());
        searchTable.setTableModel(new TableModel(new ArrayList<Student>()));
        searchTable.getToolBar().setVisible(true);
        addComponent(dialogPanel, searchTable, 1, 0, 2);

        JButton btSearch = new JButton("Search");
        btSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                boolean isStudSNSelected = searchPanel.getCheckBox(searchPanel.STUDENT_SURNAME).isSelected();
                boolean isStudFNSelected = searchPanel.getCheckBox(searchPanel.STUDENT_FIRST_NAME).isSelected();
                boolean isStudPTSelected = searchPanel.getCheckBox(searchPanel.STUDENT_PATRONYMIC).isSelected();

                boolean isLowerLimitSelected = searchPanel.getCheckBox(searchPanel.SALARY_LOWER_LIMIT).isSelected();
                boolean isUpperLimitSelected = searchPanel.getCheckBox(searchPanel.SALARY_UPPER_LIMIT).isSelected();

                String studSN = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_SURNAME);
                String studFN = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_FIRST_NAME);
                String studPN = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_PATRONYMIC);

                double lowerLimit = (double) searchPanel.getInputFieldValue(searchPanel.SALARY_LOWER_LIMIT);
                double upperLimit = (double) searchPanel.getInputFieldValue(searchPanel.SALARY_UPPER_LIMIT);

                int siblingAmount = (int) searchPanel.getInputFieldValue(searchPanel.SIBLING_AMOUNT);

                if (searchPanel.getRbStudent().isSelected()) {
                    if (isValid(searchPanel.STUDENT_SURNAME, searchPanel.STUDENT_FIRST_NAME, searchPanel.STUDENT_PATRONYMIC)) {
                        if (isStudSNSelected && isStudFNSelected && isStudPTSelected) {
                            List<Student> studentList = studentDataBase.studentSnFnPnSearch(studSN, studFN, studPN);
                            searchTable.getStudentDataBase().setStudents(studentList);
                        }
                        searchTable.updateTable();
                    }
                } else if (searchPanel.getRbFather().isSelected()) {
                    if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {

                    }
                } else if (searchPanel.getRbMother().isSelected()) {
                    if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {

                    }

                } else if (searchPanel.getRbFatherSalary().isSelected()) {
                    if (isLowerLimitSelected && isUpperLimitSelected) {
                        List<Student> studentList = studentDataBase.fatherLowUppSalarySearch(lowerLimit, upperLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    } else if (isLowerLimitSelected) {
                        List<Student> studentList = studentDataBase.fatherLowSalarySearch(lowerLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    } else if (isUpperLimitSelected) {
                        List<Student> studentList = studentDataBase.fatherUppSalarySearch(upperLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    }
                    searchTable.updateTable();
                } else if (searchPanel.getRbMotherSalary().isSelected()) {
                    if (isLowerLimitSelected && isUpperLimitSelected) {
                        List<Student> studentList = studentDataBase.motherLowUppSalarySearch(lowerLimit, upperLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    } else if (isLowerLimitSelected) {
                        List<Student> studentList = studentDataBase.motherLowSalarySearch(lowerLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    } else if (isUpperLimitSelected) {
                        List<Student> studentList = studentDataBase.motherUppSalarySearch(upperLimit);
                        searchTable.getStudentDataBase().setStudents(studentList);
                    }
                    searchTable.updateTable();
                } else if (searchPanel.getRbBrotherNumber().isSelected()) {
                    List<Student> studentList = studentDataBase.brothersAmountSearch(siblingAmount);
                    searchTable.getStudentDataBase().setStudents(studentList);
                    searchTable.updateTable();
                } else if (searchPanel.getRbSisterNumber().isSelected()) {
                    List<Student> studentList = studentDataBase.sistersAmountSearch(siblingAmount);
                    searchTable.getStudentDataBase().setStudents(studentList);
                    searchTable.updateTable();
                }
            }
        });
        addComponent(dialogPanel, btSearch, 0, 1, 3);

        searchStudentDialog.add(dialogPanel, BorderLayout.CENTER);
        searchStudentDialog.setVisible(true);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, int gridWidth) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }

    private boolean isValid(int surnameField, int firstNameField, int patronymicField) {
        boolean isValid = true;
        Pattern nameField = Pattern.compile("([A-Z])[a-z]+");
        JTextField tfSurname = (JTextField) searchPanel.getInputFieldList().get(surnameField);
        JTextField tfFirstName = (JTextField) searchPanel.getInputFieldList().get(firstNameField);
        JTextField tfPatronymic = (JTextField) searchPanel.getInputFieldList().get(patronymicField);
        if (!nameField.matcher(tfSurname.getText()).matches() && tfSurname.isEnabled()) {
            isValid = false;
            showMassage(tfSurname, tfSurname.getName() + " surname");
        } else if (!nameField.matcher(tfFirstName.getText()).matches() && tfFirstName.isEnabled()) {
            isValid = false;
            showMassage(tfFirstName, tfFirstName.getName() + "first name");
        } else if (!nameField.matcher(tfPatronymic.getText()).matches() && tfFirstName.isEnabled()) {
            isValid = false;
            showMassage(tfPatronymic, tfPatronymic.getName() + "patronymic");
        }
        return isValid;
    }

    private void showMassage(JTextField textField, String mistakeName) {
        JOptionPane.showMessageDialog(searchStudentDialog, mistakeName + " was incorrectly entered!");
        textField.setText("");
        textField.requestFocus();
    }

    private Object readInputField(int inputField) {
        return searchPanel.getInputFieldList().get(inputField);
    }


}
