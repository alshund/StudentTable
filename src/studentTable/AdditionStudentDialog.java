package studentTable;

import studentDataBase.Father;
import studentDataBase.Mother;
import studentDataBase.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;


/**
 * Created by shund on 12.04.2017.
 */
public class AdditionStudentDialog {
    private JDialog additionStudentDialog;
    private TableWithPaging tableWithPaging;

    private JTextField tfStudentSurname;
    private JTextField tfStudentFirstName;
    private JTextField tfStudentPatronymic;
    private JTextField tfMotherSurname;
    private JTextField tfMotherFirstName;
    private JTextField tfMotherPatronymic;
    private JSpinner spMotherSalary;
    private JTextField tfFatherSurname;
    private JTextField tfFatherFirstName;
    private JTextField tfFatherPatronymic;
    private JSpinner spFatherSalary;
    private JSpinner spBrothersNumber;
    private JSpinner spSistersNumber;

    public AdditionStudentDialog(JFrame mainFrame, TableWithPaging tableWithPaging) {
        additionStudentDialog = new JDialog(mainFrame, "Student addition", true);
        additionStudentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        additionStudentDialog.setSize(600, 350);
        additionStudentDialog.setLayout(new BorderLayout());
        additionStudentDialog.setLocationRelativeTo(tableWithPaging);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridBagLayout());

        JLabel lbStudentSurname = new JLabel("Student surname");
        lbStudentSurname.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbStudentSurname, 0, 0, 2, 1);
        tfStudentSurname = new JTextField();
        addComponent(dialogPanel, tfStudentSurname, 2, 0, 2, 1);

        JLabel lbStudentFirstName = new JLabel("Student first name");
        lbStudentFirstName.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbStudentFirstName, 0, 1, 2, 1);
        tfStudentFirstName = new JTextField();
        addComponent(dialogPanel, tfStudentFirstName, 2, 1, 2, 1);

        JLabel lbStudentPatronymic = new JLabel("Student patronymic");
        lbStudentPatronymic.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbStudentPatronymic, 0, 2, 2, 1);
        tfStudentPatronymic = new JTextField();
        addComponent(dialogPanel, tfStudentPatronymic, 2, 2, 2, 1);

        JLabel lbMotherSurname = new JLabel("Mother surname");
        lbMotherSurname.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbMotherSurname, 0, 3, 1, 1);
        tfMotherSurname = new JTextField();
        addComponent(dialogPanel, tfMotherSurname, 1, 3, 1, 1);

        JLabel lbFatherSurname = new JLabel("Father surname");
        lbFatherSurname.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbFatherSurname, 2, 3, 1, 1);
        tfFatherSurname = new JTextField();
        addComponent(dialogPanel, tfFatherSurname, 3, 3, 1, 1);

        JLabel lbMotherFirstName = new JLabel("Mother first name");
        lbMotherFirstName.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbMotherFirstName, 0, 4, 1, 1);
        tfMotherFirstName = new JTextField();
        addComponent(dialogPanel, tfMotherFirstName, 1, 4, 1, 1);

        JLabel lbFatherFirstName = new JLabel("Father first name");
        lbFatherFirstName.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbFatherFirstName, 2, 4, 1, 1);
        tfFatherFirstName = new JTextField();
        addComponent(dialogPanel, tfFatherFirstName, 3, 4, 1, 1);

        JLabel lbMotherPatronymic = new JLabel("Mother patronymic");
        lbMotherPatronymic.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbMotherPatronymic, 0, 5, 1, 1);
        tfMotherPatronymic = new JTextField();
        addComponent(dialogPanel, tfMotherPatronymic, 1, 5, 1, 1);

        JLabel lbFatherPatronymic = new JLabel("Father patronymic");
        lbFatherPatronymic.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbFatherPatronymic, 2, 5, 1, 1);
        tfFatherPatronymic = new JTextField();
        addComponent(dialogPanel, tfFatherPatronymic, 3, 5, 1, 1);

        SpinnerNumberModel spmMotherSalary = new SpinnerNumberModel(0.0, 0.0, null, 0.1);
        JLabel lbMotherSalary = new JLabel("Mother salary");
        lbMotherSalary.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbMotherSalary, 0, 6, 1, 1);
        spMotherSalary = new JSpinner();
        spMotherSalary.setModel(spmMotherSalary);
        addComponent(dialogPanel, spMotherSalary, 1, 6, 1, 1);

        SpinnerNumberModel spmFatherSalary = new SpinnerNumberModel(0.0, 0.0, null, 0.1);
        JLabel lbFatherSalary = new JLabel("Father salary");
        lbFatherSalary.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbFatherSalary, 2, 6, 1, 1);
        spFatherSalary = new JSpinner();
        spFatherSalary.setModel(spmFatherSalary);
        addComponent(dialogPanel, spFatherSalary, 3, 6, 1, 1);

        SpinnerNumberModel spmSistersNumber = new SpinnerNumberModel(0, 0, null, 1);
        JLabel lbSistersNumber = new JLabel("Sisters number");
        lbSistersNumber.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbSistersNumber, 0, 7, 1, 1);
        spSistersNumber = new JSpinner();
        spSistersNumber.setModel(spmSistersNumber);
        addComponent(dialogPanel, spSistersNumber, 1, 7, 1, 1);

        SpinnerNumberModel spmBrothersNumber = new SpinnerNumberModel(0, 0, null, 1);
        JLabel lbBrothersNumber = new JLabel("Brothers number");
        lbBrothersNumber.setHorizontalAlignment(JLabel.CENTER);
        addComponent(dialogPanel, lbBrothersNumber, 2, 7, 1, 1);
        spBrothersNumber = new JSpinner();
        spBrothersNumber.setModel(spmBrothersNumber);
        addComponent(dialogPanel, spBrothersNumber, 3, 7, 1, 1);

        JButton btAdditionStudent = new JButton("Addition student");
        btAdditionStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (isValid()) {
                    tableWithPaging.getStudentDataBase().addStudent(readStudent());
                    tableWithPaging.updateTable();
                    additionStudentDialog.dispose();
                }
            }
        });
        addComponent(dialogPanel, btAdditionStudent, 0, 8, 4, 1);

        additionStudentDialog.add(dialogPanel, BorderLayout.CENTER);
        additionStudentDialog.setVisible(true);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, int gridWidth, int gridHeight) {
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }

    private Student readStudent() {
        Student currentStudent = new Student();
        currentStudent.setSurname(tfStudentSurname.getText());
        currentStudent.setFirstName(tfStudentFirstName.getText());
        currentStudent.setPatronymic(tfStudentPatronymic.getText());
        currentStudent.setFather(readStudentFather());
        currentStudent.setMother(readStudentMother());
        currentStudent.setBrothersAmount((Integer) spBrothersNumber.getValue());
        currentStudent.setSistersAmount((Integer) spSistersNumber.getValue());
        return currentStudent;
    }

    private Father readStudentFather() {
        return new Father(tfFatherSurname.getText(), tfFatherFirstName.getText(), tfFatherPatronymic.getText(),
                (Double) spFatherSalary.getValue());
    }

    private Mother readStudentMother() {
        return new Mother(tfMotherSurname.getText(), tfMotherFirstName.getText(), tfMotherPatronymic.getText(),
                (Double) spMotherSalary.getValue());
    }

    private boolean isValid() {
        boolean isValid = true;
        Pattern nameField = Pattern.compile("([А-Я])[а-я]+");
        if (!nameField.matcher(tfStudentSurname.getText()).matches()) {
            isValid = false;
            showMassage(tfStudentSurname, "Student surname");
        } else if (!nameField.matcher(tfStudentFirstName.getText()).matches()) {
            isValid = false;
            showMassage(tfStudentFirstName, "Student first name");
        } else if (!nameField.matcher(tfStudentPatronymic.getText()).matches()) {
            isValid = false;
            showMassage(tfStudentPatronymic, "Student patronymic");
        } else if (!nameField.matcher(tfMotherSurname.getText()).matches()) {
            isValid = false;
            showMassage(tfMotherSurname, "Mother surname");
        } else if (!nameField.matcher(tfMotherFirstName.getText()).matches()) {
            isValid = false;
            showMassage(tfMotherFirstName, "Mother first name");
        } else if (!nameField.matcher(tfMotherPatronymic.getText()).matches()) {
            isValid = false;
            showMassage(tfMotherPatronymic, "Mother patronymic");
        } else if (!nameField.matcher(tfFatherSurname.getText()).matches()) {
            isValid = false;
            showMassage(tfFatherSurname, "Father surname");
        } else if (!nameField.matcher(tfFatherFirstName.getText()).matches()) {
            isValid = false;
            showMassage(tfFatherFirstName, "Father first name");
        } else if (!nameField.matcher(tfFatherPatronymic.getText()).matches()) {
            isValid = false;
            showMassage(tfFatherPatronymic, "Father patronymic");
        }
        return isValid;
    }

    private void showMassage(JTextField textField, String mistakeName) {
        JOptionPane.showMessageDialog(additionStudentDialog, mistakeName + " was incorrectly entered!");
        textField.setText("");
        textField.requestFocus();
    }
}
