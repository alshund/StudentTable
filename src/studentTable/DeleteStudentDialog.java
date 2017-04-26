package studentTable;

import studentDataBase.Student;
import tableController.DeleteStudentListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by shund on 25.04.2017.
 */
public class DeleteStudentDialog {
    JDialog deleteStudentDialog;
    SearchPanel searchPanel;
    TableWithPaging tableWithPaging;

    public DeleteStudentDialog(JFrame mainFrame, TableWithPaging tableWithPaging) {
        this.tableWithPaging = tableWithPaging;

        deleteStudentDialog = new JDialog(mainFrame, "Delete student", true);
        deleteStudentDialog.setSize(350, 650);
        deleteStudentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        deleteStudentDialog.setLayout(new BorderLayout());
        deleteStudentDialog.setLocationRelativeTo(tableWithPaging);

        searchPanel = new SearchPanel();

        deleteStudentDialog.add(searchPanel.getSearchPanel(), BorderLayout.CENTER);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        deleteStudentDialog.add(deleteButton, BorderLayout.SOUTH);

        deleteStudentDialog.setVisible(true);
    }

    class DeleteButtonListener implements ActionListener {
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

        public DeleteButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            boolean isFound = false;
            int recodesAmount = tableWithPaging.getStudentDataBase().getStudents().size();
            if (searchPanel.getRbStudent().isSelected()) {
                if (isValid(searchPanel.STUDENT_SURNAME, searchPanel.STUDENT_FIRST_NAME, searchPanel.STUDENT_PATRONYMIC)) {
                    isFound = true;
                    setStudCbSelected();
                    setStudValue();
                    if (isStudSNSelected && isStudFNSelected && isStudPTSelected) {
                        tableWithPaging.getStudentDataBase().studentSnFnPtDelete(studSN, studFN, studPT);
                    } else if (isStudSNSelected && isStudFNSelected) {
                        tableWithPaging.getStudentDataBase().studentSnFnDelete(studSN, studFN);
                    } else if (isStudSNSelected && isStudPTSelected) {
                        tableWithPaging.getStudentDataBase().studentSnPtDelete(studSN, studPT);
                    } else if (isStudFNSelected && isStudPTSelected) {
                        tableWithPaging.getStudentDataBase().studentFnPtDelete(studFN, studPT);
                    } else if (isStudSNSelected) {
                        tableWithPaging.getStudentDataBase().studentSnDelete(studSN);
                    } else if (isStudFNSelected) {
                        tableWithPaging.getStudentDataBase().studentFnDelete(studFN);
                    } else if (isStudPTSelected) {
                        tableWithPaging.getStudentDataBase().studentPtDelete(studPT);
                    }
                    tableWithPaging.updateTable();
                }
            } else if (searchPanel.getRbFather().isSelected()) {
                if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {
                    isFound = true;
                    setParCdSelected();
                    setParValue();
                    if (isParSNSelected && isParFNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().fatherSnFnPtDelete(parSN, parFN, parPT);
                    } else if (isParSNSelected && isParFNSelected) {
                        tableWithPaging.getStudentDataBase().fatherSnFnDelete(parSN, parFN);
                    } else if (isParSNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().fatherSnPtDelete(parSN, parPT);
                    } else if (isParFNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().fatherFnPtDelete(parFN, parPT);
                    } else if (isParSNSelected) {
                        tableWithPaging.getStudentDataBase().fatherSnDelete(parSN);
                    } else if (isParFNSelected) {
                        tableWithPaging.getStudentDataBase().fatherFnDelete(parFN);
                    } else if (isParPTSelected) {
                        tableWithPaging.getStudentDataBase().fatherPtSearch(parPT);
                    }
                    tableWithPaging.updateTable();
                }
            } else if (searchPanel.getRbMother().isSelected()) {
                if (isValid(searchPanel.PARENT_SURNAME, searchPanel.PARENT_FIRST_NAME, searchPanel.PARENT_PATRONYMIC)) {
                    isFound = true;
                    setParCdSelected();
                    setParValue();
                    if (isParSNSelected && isParFNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().motherSnFnPtDelete(parSN, parFN, parPT);
                    } else if (isParSNSelected && isParFNSelected) {
                        tableWithPaging.getStudentDataBase().motherSnFnDelete(parSN, parFN);
                    } else if (isParSNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().motherSnPtDelete(parSN, parPT);
                    } else if (isParFNSelected && isParPTSelected) {
                        tableWithPaging.getStudentDataBase().motherFnPtDelete(parFN, parPT);
                    } else if (isParSNSelected) {
                        tableWithPaging.getStudentDataBase().motherSnDelete(parSN);
                    } else if (isParFNSelected) {
                        tableWithPaging.getStudentDataBase().motherFnDelete(parFN);
                    } else if (isParPTSelected) {
                        tableWithPaging.getStudentDataBase().motherPtDelete(parPT);
                    }
                    tableWithPaging.updateTable();
                }
            } else if (searchPanel.getRbFatherSalary().isSelected()) {
                isFound = true;
                setSalCdSelected();
                setSalValue();
                if (isLowerLimitSelected && isUpperLimitSelected) {
                    tableWithPaging.getStudentDataBase().fatherLowUppSalaryDelete(lowerLimit, upperLimit);
                } else if (isLowerLimitSelected) {
                    tableWithPaging.getStudentDataBase().fatherLowSalaryDelete(lowerLimit);
                } else if (isUpperLimitSelected) {
                   tableWithPaging.getStudentDataBase().fatherUppSalaryDelete(upperLimit);
                }
                tableWithPaging.updateTable();
            } else if (searchPanel.getRbMotherSalary().isSelected()) {
                isFound = true;
                setSalCdSelected();
                setSalValue();
                if (isLowerLimitSelected && isUpperLimitSelected) {
                    tableWithPaging.getStudentDataBase().motherLowUppSalaryDelete(lowerLimit, upperLimit);
                } else if (isLowerLimitSelected) {
                    tableWithPaging.getStudentDataBase().motherLowSalaryDelete(lowerLimit);
                } else if (isUpperLimitSelected) {
                    tableWithPaging.getStudentDataBase().motherUppSalaryDelete(upperLimit);
                }
                tableWithPaging.updateTable();
            } else if (searchPanel.getRbBrotherNumber().isSelected()) {
                isFound = true;
                setSiblingAmountValue();
                tableWithPaging.getStudentDataBase().brothersAmountDelete(siblingAmount);
                tableWithPaging.updateTable();
            } else if (searchPanel.getRbSisterNumber().isSelected()) {
                isFound = true;
                setSiblingAmountValue();
                tableWithPaging.getStudentDataBase().sistersAmountDelete(siblingAmount);
                tableWithPaging.updateTable();
            }
            if (isFound) {
                recodesAmount = recodesAmount - tableWithPaging.getStudentDataBase().getStudents().size();
                JOptionPane.showMessageDialog(deleteStudentDialog, "The deletion is complete. Number of deleted records: " + recodesAmount, "Delete", JOptionPane.INFORMATION_MESSAGE);
                deleteStudentDialog.dispose();
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
                JOptionPane.showMessageDialog(deleteStudentDialog, "Select the search parameter", "Parameter error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(deleteStudentDialog, mistakeName + " was incorrectly entered!");
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
            siblingAmount = (int) searchPanel.getInputFieldValue(searchPanel.SIBLING_AMOUNT);
        }
    }
}
