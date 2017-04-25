package studentTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shund on 23.04.2017.
 */
public class SearchPanel {
    public static final int STUDENT_SURNAME = 0;
    public static final int STUDENT_FIRST_NAME = 1;
    public static final int STUDENT_PATRONYMIC = 2;
    public static final int PARENT_SURNAME = 3;
    public static final int PARENT_FIRST_NAME = 4;
    public static final int PARENT_PATRONYMIC = 5;
    public static final int SALARY_LOWER_LIMIT = 6;
    public static final int SALARY_UPPER_LIMIT = 7;
    public static final int SIBLING_AMOUNT = 8;


    private JPanel searchPanel;
    private List<JComponent> inputFieldList;
    private List<JComponent> checkBoxFieldList;
    private JRadioButton rbStudent;
    private JRadioButton rbFather;
    private JRadioButton rbFatherSalary;
    private JRadioButton rbMother;
    private JRadioButton rbMotherSalary;
    private JRadioButton rbBrotherNumber;
    private JRadioButton rbSisterNumber;

    public SearchPanel() {
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());

        inputFieldList = new ArrayList<JComponent>();
        ButtonGroup buttonGroup = new ButtonGroup();

        checkBoxFieldList = new ArrayList<JComponent>();

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridBagLayout());
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student"));

        rbStudent = new JRadioButton("Student");
        addComponent(studentPanel, rbStudent, 0, 0, 1, 1);
        buttonGroup.add(rbStudent);

        JCheckBox cbStudentSurname = new JCheckBox("Surname");
        cbStudentSurname.setName("Student");
        cbStudentSurname.setEnabled(false);
        checkBoxFieldList.add(cbStudentSurname);
        addComponent(studentPanel, cbStudentSurname, 0, 1, 1, 1);

        JTextField tfStudentSurname = new JTextField("", 10);
        tfStudentSurname.setName("Student surname");
        tfStudentSurname.setEnabled(false);
        inputFieldList.add(tfStudentSurname);
        addComponent(studentPanel, tfStudentSurname, 1, 1, 2, 1);

        JCheckBox cbStudentFirstName = new JCheckBox("First name");
        cbStudentFirstName.setName("Student");
        cbStudentFirstName.setEnabled(false);
        checkBoxFieldList.add(cbStudentFirstName);
        addComponent(studentPanel, cbStudentFirstName, 0, 2, 1, 1);

        JTextField tfStudentFirstName = new JTextField("", 10);
        tfStudentFirstName.setName("Student first name");
        tfStudentFirstName.setEnabled(false);
        inputFieldList.add(tfStudentFirstName);
        addComponent(studentPanel, tfStudentFirstName, 1, 2, 2, 1);

        JCheckBox cbStudentPatronymic = new JCheckBox("Patronymic");
        cbStudentPatronymic.setName("Student");
        cbStudentPatronymic.setEnabled(false);
        checkBoxFieldList.add(cbStudentPatronymic);
        addComponent(studentPanel, cbStudentPatronymic, 0, 3, 1, 1);

        JTextField tfStudentPatronymic = new JTextField("", 10);
        tfStudentPatronymic.setName("Student patronymic");
        tfStudentPatronymic.setEnabled(false);
        inputFieldList.add(tfStudentPatronymic);
        addComponent(studentPanel, tfStudentPatronymic, 1, 3, 2, 1);

        rbStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : checkBoxFieldList) {
                    if (component.getName().equals("Student")) {
                        component.setEnabled(true);
                    } else {
                        JCheckBox checkBox = (JCheckBox) component;
                        checkBox.setSelected(false);
                        component.setEnabled(false);
                    }
                }
            }
        });

        cbStudentSurname.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbStudentSurname.isSelected()) {
                    inputFieldList.get(STUDENT_SURNAME).setEnabled(true);
                } else {
                    inputFieldList.get(STUDENT_SURNAME).setEnabled(false);
                }
            }
        });

        cbStudentFirstName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbStudentFirstName.isSelected()) {
                    inputFieldList.get(STUDENT_FIRST_NAME).setEnabled(true);
                } else {
                    inputFieldList.get(STUDENT_FIRST_NAME).setEnabled(false);
                }
            }
        });

        cbStudentPatronymic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbStudentPatronymic.isSelected()) {
                    inputFieldList.get(STUDENT_PATRONYMIC).setEnabled(true);
                } else {
                    inputFieldList.get(STUDENT_PATRONYMIC).setEnabled(false);
                }
            }
        });

        addComponent(searchPanel, studentPanel, 0, 0, 1, 1);

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new GridBagLayout());
        parentPanel.setBorder(BorderFactory.createTitledBorder("Parent"));

        rbFather = new JRadioButton("Father");
        addComponent(parentPanel, rbFather, 0, 0, 1, 1);
        buttonGroup.add(rbFather);

        rbMother = new JRadioButton("Mother");
        addComponent(parentPanel, rbMother, 1, 0, 1, 1);
        buttonGroup.add(rbMother);

        JCheckBox cbParentSurname = new JCheckBox("Surname");
        cbParentSurname.setName("Parent");
        cbParentSurname.setEnabled(false);
        checkBoxFieldList.add(cbParentSurname);
        addComponent(parentPanel, cbParentSurname, 0, 1, 1, 1);

        JTextField tfParentSurname = new JTextField("", 10);
        tfParentSurname.setName("Parent surname");
        tfParentSurname.setEnabled(false);
        inputFieldList.add(tfParentSurname);
        addComponent(parentPanel, tfParentSurname, 1, 1, 2, 1);


        JCheckBox cbParentFirstName = new JCheckBox("First name");
        cbParentFirstName.setName("Parent");
        cbParentFirstName.setEnabled(false);
        checkBoxFieldList.add(cbParentFirstName);
        addComponent(parentPanel, cbParentFirstName, 0, 2, 1, 1);

        JTextField tfParentFirstName = new JTextField("", 10);
        tfParentFirstName.setName("Parent first name");
        tfParentFirstName.setEnabled(false);
        inputFieldList.add(tfParentFirstName);
        addComponent(parentPanel, tfParentFirstName, 1, 2, 2, 1);

        JCheckBox cbParentPatronymic = new JCheckBox("Patronymic");
        cbParentPatronymic.setName("Parent");
        cbParentPatronymic.setEnabled(false);
        checkBoxFieldList.add(cbParentPatronymic);
        addComponent(parentPanel, cbParentPatronymic, 0, 3, 1, 1);

        JTextField tfParentPatronymic = new JTextField("", 10);
        tfParentPatronymic.setName("Parent patronymic");
        tfParentPatronymic.setEnabled(false);
        inputFieldList.add(tfParentPatronymic);
        addComponent(parentPanel, tfParentPatronymic, 1, 3, 2, 1);

        rbFather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : checkBoxFieldList) {
                    if (component.getName().equals("Parent")) {
                        component.setEnabled(true);
                    } else {
                        JCheckBox checkBox = (JCheckBox) component;
                        checkBox.setSelected(false);
                        component.setEnabled(false);                    }
                }
            }
        });

        rbMother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : checkBoxFieldList) {
                    if (component.getName().equals("Parent")) {
                        component.setEnabled(true);
                    } else {
                        JCheckBox checkBox = (JCheckBox) component;
                        checkBox.setSelected(false);
                        component.setEnabled(false);                    }
                }
            }
        });

        cbParentSurname.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbParentSurname.isSelected()) {
                    inputFieldList.get(PARENT_SURNAME).setEnabled(true);
                } else {
                    inputFieldList.get(PARENT_SURNAME).setEnabled(false);
                }
            }
        });

        cbParentFirstName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbParentFirstName.isSelected()) {
                    inputFieldList.get(PARENT_FIRST_NAME).setEnabled(true);
                } else {
                    inputFieldList.get(PARENT_FIRST_NAME).setEnabled(false);
                }
            }
        });

        cbParentPatronymic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbParentPatronymic.isSelected()) {
                    inputFieldList.get(PARENT_PATRONYMIC).setEnabled(true);
                } else {
                    inputFieldList.get(PARENT_PATRONYMIC).setEnabled(false);
                }
            }
        });

        addComponent(searchPanel, parentPanel, 0, 1, 1, 1);

        JPanel salaryPanel = new JPanel();
        salaryPanel.setLayout(new GridBagLayout());
        salaryPanel.setBorder(BorderFactory.createTitledBorder("Salary"));

        rbFatherSalary = new JRadioButton("Father");
        addComponent(salaryPanel, rbFatherSalary, 0, 0, 1, 1);
        buttonGroup.add(rbFatherSalary);

        rbMotherSalary = new JRadioButton("Mother");
        addComponent(salaryPanel, rbMotherSalary, 1, 0, 1, 1);
        buttonGroup.add(rbMotherSalary);

        JCheckBox cbLowerLimit = new JCheckBox("Lower limit");
        cbLowerLimit.setName("Salary");
        cbLowerLimit.setEnabled(false);
        checkBoxFieldList.add(cbLowerLimit);
        addComponent(salaryPanel, cbLowerLimit, 0, 1, 1, 1);

        SpinnerNumberModel spmLowerLimit = new SpinnerNumberModel(0.0, 0.0, null, 0.1);

        JSpinner spLowerLimit = new JSpinner(spmLowerLimit);
        spLowerLimit.setName("Salary lower limit");
        spLowerLimit.setEnabled(false);
        inputFieldList.add(spLowerLimit);
        addComponent(salaryPanel, spLowerLimit, 1, 1, 2, 1);

        JCheckBox cbUpperLimit = new JCheckBox("Upper limit");
        cbUpperLimit.setName("Salary");
        cbUpperLimit.setEnabled(false);
        checkBoxFieldList.add(cbUpperLimit);
        addComponent(salaryPanel, cbUpperLimit, 0, 2, 1, 1);

        SpinnerNumberModel spmUpperLimit = new SpinnerNumberModel(0.0, 0.0, null, 0.1);

        JSpinner spUpperLimit = new JSpinner(spmUpperLimit);
        spUpperLimit.setName("Salary upper limit");
        spUpperLimit.setEnabled(false);
        inputFieldList.add(spUpperLimit);
        addComponent(salaryPanel, spUpperLimit, 1, 2, 2, 1);

        rbFatherSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : checkBoxFieldList) {
                    if (component.getName().equals("Salary")) {
                        component.setEnabled(true);
                    } else {
                        JCheckBox checkBox = (JCheckBox) component;
                        checkBox.setSelected(false);
                        component.setEnabled(false);                      }
                }
            }
        });

        rbMotherSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : checkBoxFieldList) {
                    if (component.getName().equals("Salary")) {
                        component.setEnabled(true);
                    } else {
                        JCheckBox checkBox = (JCheckBox) component;
                        checkBox.setSelected(false);
                        component.setEnabled(false);                      }
                }
            }
        });

        cbLowerLimit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbLowerLimit.isSelected()) {
                    inputFieldList.get(SALARY_LOWER_LIMIT).setEnabled(true);
                } else {
                    inputFieldList.get(SALARY_LOWER_LIMIT).setEnabled(false);
                }
            }
        });

        cbUpperLimit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (cbUpperLimit.isSelected()) {
                    inputFieldList.get(SALARY_UPPER_LIMIT).setEnabled(true);
                } else {
                    inputFieldList.get(SALARY_UPPER_LIMIT).setEnabled(false);
                }
            }
        });

        addComponent(searchPanel, salaryPanel, 0, 3, 1, 1);

        JPanel siblingPanel = new JPanel();
        siblingPanel.setLayout(new GridBagLayout());
        siblingPanel.setBorder(BorderFactory.createTitledBorder("Brother and sisters"));

        rbBrotherNumber = new JRadioButton("Brother's");
        addComponent(siblingPanel, rbBrotherNumber, 0, 0, 1, 1);
        buttonGroup.add(rbBrotherNumber);

        rbSisterNumber = new JRadioButton("Sister's");
        addComponent(siblingPanel, rbSisterNumber, 1, 0, 1, 1);
        buttonGroup.add(rbSisterNumber);

        JLabel lbBrStNumber = new JLabel("Amount");
        addComponent(siblingPanel, lbBrStNumber, 0, 1, 1, 1);

        SpinnerNumberModel spmBrStAmount = new SpinnerNumberModel(0, 0, null, 1);
        JSpinner spSiblingAmount = new JSpinner(spmBrStAmount);
        spSiblingAmount.setName("Sibling Amount");
        spSiblingAmount.setEnabled(false);
        inputFieldList.add(spSiblingAmount);
        addComponent(siblingPanel, spSiblingAmount, 1, 1, 2, 1);

        rbBrotherNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : inputFieldList) {
                    if (component.getName().equals("Sibling Amount")) {
                        component.setEnabled(true);
                    } else {
                        int checkBoxPosition = inputFieldList.indexOf(component);
                        if (checkBoxPosition < checkBoxFieldList.size()){
                            JCheckBox checkBox = (JCheckBox) checkBoxFieldList.get(checkBoxPosition);
                            checkBox.setSelected(false);
                            checkBox.setEnabled(false);
                        }
                        component.setEnabled(false);
                    }
                }
            }
        });

        rbBrotherNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (rbBrotherNumber.isSelected()) {
                    spSiblingAmount.setEnabled(true);
                } else {
                    spSiblingAmount.setEnabled(false);
                }
            }
        });

        rbSisterNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JComponent component : inputFieldList) {
                    if (component.getName().equals("Sibling Amount")) {
                        component.setEnabled(true);
                    } else {
                        component.setEnabled(false);
                    }
                }
            }
        });

        rbSisterNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(rbSisterNumber.isSelected()) {
                    spSiblingAmount.setEnabled(true);
                } else {
                    spSiblingAmount.setEnabled(false);
                }
            }
        });

        addComponent(searchPanel, siblingPanel, 0, 4, 1, 1);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, int gridWidth, int gridHeight) {
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public List<JComponent> getInputFieldList() {
        return inputFieldList;
    }

    public Object getInputFieldValue (int ifIndex) {
        JTextField textField;
        JSpinner spinner;
        if (ifIndex == STUDENT_SURNAME) {
            textField = (JTextField) inputFieldList.get(STUDENT_SURNAME);
            return textField.getText();
        } else if (ifIndex == STUDENT_FIRST_NAME) {
            textField = (JTextField) inputFieldList.get(STUDENT_FIRST_NAME);
            return  textField.getText();
        } else if (ifIndex == STUDENT_PATRONYMIC) {
            textField = (JTextField) inputFieldList.get(STUDENT_PATRONYMIC);
            return textField.getText();
        } else if (ifIndex == PARENT_SURNAME) {
            textField = (JTextField) inputFieldList.get(PARENT_SURNAME);
            return textField.getText();
        } else if (ifIndex == PARENT_FIRST_NAME) {
            textField = (JTextField) inputFieldList.get(PARENT_FIRST_NAME);
            return textField.getText();
        } else if (ifIndex == PARENT_PATRONYMIC) {
            textField = (JTextField) inputFieldList.get(PARENT_PATRONYMIC);
            return textField.getText();
        } else if (ifIndex == SALARY_LOWER_LIMIT) {
            spinner = (JSpinner) inputFieldList.get(SALARY_LOWER_LIMIT);
            return spinner.getValue();
        } else if (ifIndex == SALARY_UPPER_LIMIT) {
            spinner = (JSpinner) inputFieldList.get(SALARY_UPPER_LIMIT);
            return spinner.getValue();
        } else if (ifIndex == SIBLING_AMOUNT) {
            spinner = (JSpinner) inputFieldList.get(SIBLING_AMOUNT);
            return spinner.getValue();
        } else {
            return null;
        }
    }

    public List<JComponent> getCheckBoxFieldList() {
        return checkBoxFieldList;
    }

    public JCheckBox getCheckBox (int cbIndex){
        JCheckBox checkBox;
        if (cbIndex == STUDENT_SURNAME) {
            checkBox = (JCheckBox) checkBoxFieldList.get(STUDENT_SURNAME);
            return checkBox;
        } else if (cbIndex == STUDENT_FIRST_NAME) {
            checkBox = (JCheckBox) checkBoxFieldList.get(STUDENT_FIRST_NAME);
            return checkBox;
        } else if (cbIndex == STUDENT_PATRONYMIC) {
            checkBox = (JCheckBox) checkBoxFieldList.get(STUDENT_PATRONYMIC);
            return  checkBox;
        } else if (cbIndex == PARENT_SURNAME) {
            checkBox = (JCheckBox) checkBoxFieldList.get(PARENT_SURNAME);
            return  checkBox;
        } else if (cbIndex == PARENT_FIRST_NAME) {
            checkBox = (JCheckBox) checkBoxFieldList.get(PARENT_FIRST_NAME);
            return  checkBox;
        } else  if (cbIndex == PARENT_PATRONYMIC) {
            checkBox = (JCheckBox) checkBoxFieldList.get(PARENT_PATRONYMIC);
            return checkBox;
        } else if (cbIndex == SALARY_LOWER_LIMIT) {
            checkBox = (JCheckBox) checkBoxFieldList.get(SALARY_LOWER_LIMIT);
            return checkBox;
        } else if (cbIndex == SALARY_UPPER_LIMIT) {
            checkBox = (JCheckBox) checkBoxFieldList.get(SALARY_UPPER_LIMIT);
            return checkBox;
        } else {
            return null;
        }
    }

    public JRadioButton getRbStudent() {
        return rbStudent;
    }

    public JRadioButton getRbFather() {
        return rbFather;
    }

    public JRadioButton getRbFatherSalary() {
        return rbFatherSalary;
    }

    public JRadioButton getRbMother() {
        return rbMother;
    }

    public JRadioButton getRbMotherSalary() {
        return rbMotherSalary;
    }

    public JRadioButton getRbBrotherNumber() {
        return rbBrotherNumber;
    }

    public JRadioButton getRbSisterNumber() {
        return rbSisterNumber;
    }
}


