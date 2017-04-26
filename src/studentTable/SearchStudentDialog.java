package studentTable;

import studentDataBase.Student;
import studentDataBase.StudentDataBase;

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
        btSearch.addActionListener(new SearchButtonListener());
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

    class SearchButtonListener implements ActionListener {
        List<Student> studentList;

        boolean isStudSNSelected;
        boolean isStudFNSelected;
        boolean isStudPTSelected;
        boolean isParSNSelected;
        boolean isParFNSelected;
        boolean isParPTSelected;
        boolean isLowerLimitSelected;
        boolean isUpperLimitSelected;

        String studSN;
        String studFN;
        String studPT;

        String parSN;
        String parFN;
        String parPT;

        double lowerLimit;
        double upperLimit;

        int siblingAmount;

        public SearchButtonListener() {
            studentList = new ArrayList<Student>();
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            boolean isFound = false;
            if (searchPanel.getRbStudent().isSelected()) {
                if (isValid(searchPanel.STUDENT_SURNAME, searchPanel.STUDENT_FIRST_NAME, searchPanel.STUDENT_PATRONYMIC)) {
                    isFound = true;
                    setStudCbSelected();
                    setStudValue();
                    if (isStudSNSelected && isStudFNSelected && isStudPTSelected) {
                        studentList = studentDataBase.studentSnFnPtSearch(studSN, studFN, studPT);
                    } else if (isStudSNSelected && isStudFNSelected) {
                        studentList = studentDataBase.studentSnFnSearch(studSN, studFN);
                    } else if (isStudSNSelected && isStudPTSelected) {
                        studentList = studentDataBase.studentSnPtSearch(studSN, studPT);
                    } else if (isStudFNSelected && isStudPTSelected) {
                        studentList = studentDataBase.studentFnPtSearch(studFN, studPT);
                    } else if (isStudSNSelected) {
                        studentList = studentDataBase.studentSnSearch(studSN);
                    } else if (isStudFNSelected) {
                        studentList = studentDataBase.studentFnSearch(studFN);
                    } else if (isStudPTSelected) {
                        studentList = studentDataBase.studentPtSearch(studPT);
                    }
                    searchTable.getStudentDataBase().setStudents(studentList);
                    searchTable.updateTable();
                }
            } else if (searchPanel.getRbFather().isSelected()) {
                if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {
                    isFound = true;
                    setParCdSelected();
                    setParValue();
                    if (isParSNSelected && isParFNSelected && isParPTSelected) {
                        studentList = studentDataBase.fatherSnFnPtSearch(parSN, parFN, parPT);
                    } else if (isParSNSelected && isParFNSelected) {
                        studentList = studentDataBase.fatherSnFnSearch(parSN, parFN);
                    } else if (isParSNSelected && isParPTSelected) {
                        studentList = studentDataBase.fatherSnPtSearch(parSN, parPT);
                    } else if (isParFNSelected && isParPTSelected) {
                        studentList = studentDataBase.fatherFnPtSearch(parFN, parPT);
                    } else if (isParSNSelected) {
                        studentList = studentDataBase.fatherSnSearch(parSN);
                    } else if (isParFNSelected) {
                        studentList = studentDataBase.fatherFnSearch(parFN);
                    } else if (isParPTSelected) {
                        studentList = studentDataBase.fatherPtSearch(parPT);
                    }
                    searchTable.getStudentDataBase().setStudents(studentList);
                    searchTable.updateTable();
                }
            } else if (searchPanel.getRbMother().isSelected()) {
                if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {
                    isFound = true;
                    setParCdSelected();
                    setParValue();
                    if (isParSNSelected && isParFNSelected && isParPTSelected) {
                        studentList = studentDataBase.motherSnFnPtSearch(parSN, parFN, parPT);
                    } else if (isParSNSelected && isParFNSelected) {
                        studentList = studentDataBase.motherSnFnSearch(parSN, parFN);
                    } else if (isParSNSelected && isParPTSelected) {
                        studentList = studentDataBase.motherSnPtSearch(parSN, parPT);
                    } else if (isParFNSelected && isParPTSelected) {
                        studentList = studentDataBase.motherFnPtSearch(parFN, parPT);
                    } else if (isParSNSelected) {
                        studentList = studentDataBase.motherSnSearch(parSN);
                    } else if (isParFNSelected) {
                        studentList = studentDataBase.motherFnSearch(parFN);
                    } else if (isParPTSelected) {
                        studentList = studentDataBase.motherPtSearch(parPT);
                    }
                    searchTable.getStudentDataBase().setStudents(studentList);
                    searchTable.updateTable();
                }
            } else if (searchPanel.getRbFatherSalary().isSelected()) {
                isFound = true;
                setSalCdSelected();
                setSalValue();
                if (isLowerLimitSelected && isUpperLimitSelected) {
                    studentList = studentDataBase.fatherLowUppSalarySearch(lowerLimit, upperLimit);
                } else if (isLowerLimitSelected) {
                    studentList = studentDataBase.fatherLowSalarySearch(lowerLimit);
                } else if (isUpperLimitSelected) {
                    studentList = studentDataBase.fatherUppSalarySearch(upperLimit);
                }
                searchTable.getStudentDataBase().setStudents(studentList);
                searchTable.updateTable();
            } else if (searchPanel.getRbMotherSalary().isSelected()) {
                isFound = true;
                setSalCdSelected();
                setSalValue();
                if (isLowerLimitSelected && isUpperLimitSelected) {
                    studentList = studentDataBase.motherLowUppSalarySearch(lowerLimit, upperLimit);
                } else if (isLowerLimitSelected) {
                    studentList = studentDataBase.motherLowSalarySearch(lowerLimit);
                } else if (isUpperLimitSelected) {
                    studentList = studentDataBase.motherUppSalarySearch(upperLimit);
                }
                searchTable.getStudentDataBase().setStudents(studentList);
                searchTable.updateTable();
            } else if (searchPanel.getRbBrotherNumber().isSelected()) {
                isFound = true;
                setSiblingAmountValue();
                studentList = studentDataBase.brothersAmountSearch(siblingAmount);
                searchTable.getStudentDataBase().setStudents(studentList);
                searchTable.updateTable();
            } else if (searchPanel.getRbSisterNumber().isSelected()) {
                isFound = true;
                setSiblingAmountValue();
                studentList = studentDataBase.sistersAmountSearch(siblingAmount);
                searchTable.getStudentDataBase().setStudents(studentList);
                searchTable.updateTable();
            }
            if (isFound) {
                JOptionPane.showMessageDialog(searchStudentDialog, "Found " + studentList.size() + " students", "Search", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private boolean isValid(int surname, int firstName, int patronymic) {
            boolean isValid = true;
            Pattern nameField = Pattern.compile("([А-Я])[а-я]+");
            JCheckBox cbSurname = searchPanel.getCheckBox(surname);
            JCheckBox cbFirstName = searchPanel.getCheckBox(firstName);
            JCheckBox cbPatronymic = searchPanel.getCheckBox(patronymic);
            JTextField tfSurname = (JTextField) searchPanel.getInputFieldList().get(surname);
            JTextField tfFirstName = (JTextField) searchPanel.getInputFieldList().get(firstName);
            JTextField tfPatronymic = (JTextField) searchPanel.getInputFieldList().get(patronymic);
            if (!cbSurname.isSelected() && !cbFirstName.isSelected() && !cbPatronymic.isSelected()) {
                isValid = false;
                JOptionPane.showMessageDialog(searchStudentDialog, "Select the search parameter", "Parameter error", JOptionPane.ERROR_MESSAGE);
            } else if (!nameField.matcher(tfSurname.getText()).matches() && cbSurname.isSelected()) {
                isValid = false;
                showMassage(tfSurname, tfSurname.getName());
            } else if (!nameField.matcher(tfFirstName.getText()).matches() && cbFirstName.isSelected()) {
                isValid = false;
                showMassage(tfFirstName, tfFirstName.getName());
            } else if (!nameField.matcher(tfPatronymic.getText()).matches() && cbPatronymic.isSelected()) {
                isValid = false;
                showMassage(tfPatronymic, tfPatronymic.getName());
            }
            return isValid;
        }

        private void showMassage(JTextField textField, String mistakeName) {
            JOptionPane.showMessageDialog(searchStudentDialog, mistakeName + " was incorrectly entered!");
            textField.setText("");
            textField.requestFocus();
        }

        private void setStudCbSelected() {
            isStudSNSelected = searchPanel.getCheckBox(searchPanel.STUDENT_SURNAME).isSelected();
            isStudFNSelected = searchPanel.getCheckBox(searchPanel.STUDENT_FIRST_NAME).isSelected();
            isStudPTSelected = searchPanel.getCheckBox(searchPanel.STUDENT_PATRONYMIC).isSelected();
        }

        private void setParCdSelected() {
            isParSNSelected = searchPanel.getCheckBox(searchPanel.PARENT_SURNAME).isSelected();
            isParFNSelected = searchPanel.getCheckBox(searchPanel.PARENT_FIRST_NAME).isSelected();
            isParPTSelected = searchPanel.getCheckBox(searchPanel.PARENT_PATRONYMIC).isSelected();
        }

        private void setSalCdSelected() {
            isLowerLimitSelected = searchPanel.getCheckBox(searchPanel.SALARY_LOWER_LIMIT).isSelected();
            isUpperLimitSelected = searchPanel.getCheckBox(searchPanel.SALARY_UPPER_LIMIT).isSelected();
        }

        private void setStudValue() {
            studSN = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_SURNAME);
            studFN = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_FIRST_NAME);
            studPT = (String) searchPanel.getInputFieldValue(searchPanel.STUDENT_PATRONYMIC);
        }

        private void setParValue() {
            parSN = (String) searchPanel.getInputFieldValue(searchPanel.PARENT_SURNAME);
            parFN = (String) searchPanel.getInputFieldValue(searchPanel.PARENT_FIRST_NAME);
            parPT = (String) searchPanel.getInputFieldValue(searchPanel.PARENT_PATRONYMIC);
        }

        private void setSalValue() {
            lowerLimit = (double) searchPanel.getInputFieldValue(searchPanel.SALARY_LOWER_LIMIT);
            upperLimit = (double) searchPanel.getInputFieldValue(searchPanel.SALARY_UPPER_LIMIT);
        }

        private void setSiblingAmountValue() {
            int siblingAmount = (int) searchPanel.getInputFieldValue(searchPanel.SIBLING_AMOUNT);
        }
    }
}

