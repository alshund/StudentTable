import javax.swing.*;
import java.awt.*;

/**
 * Created by shund on 12.04.2017.
 */
public class AddStudentDialogPanel extends JPanel {
    private TableArea tableArea;
    JTextField studentSurname;
    JTextField studentFirstName;
    JTextField studentMiddleName;
    JTextField motherSurname;
    JTextField motherFirstName;
    JTextField motherMiddleName;
    JTextField motherSalary;
    JTextField fatherSurname;
    JTextField fatherFirstName;
    JTextField fatherMiddleName;
    JTextField fatherSalary;
    JTextField numberOfBrothers;
    JTextField numberOfSisters;

    public AddStudentDialogPanel(TableArea tableArea) {
        this.tableArea = tableArea;
        studentSurname = new JTextField();
        studentFirstName = new JTextField();
        studentMiddleName = new JTextField();
        motherSurname = new JTextField();
        motherFirstName = new JTextField();
        motherMiddleName = new JTextField();
        motherFirstName = new JTextField();
        motherSalary = new JTextField();
        fatherSurname = new JTextField();
        fatherFirstName = new JTextField();
        fatherMiddleName = new JTextField();
        fatherSalary = new JTextField();
        numberOfBrothers = new JTextField();
        numberOfSisters = new JTextField();
        setLayout(new GridBagLayout());
        addComponents();
        addJButton();
    }

    private void addComponents() {
        addField(studentSurname, "Фамилия студента", 0, 0, 2, 1);
        addField(studentFirstName, "Имя студента", 0, 1, 2, 1);
        addField(studentMiddleName, "Отчество студента", 0, 2, 2, 1);
        addField(motherSurname, "Фамилия матери", 0, 3, 1, 1);
        addField(fatherSurname, "Фамилия отца", 2, 3, 1, 1);
        addField(motherFirstName, "Имя матери", 0, 4, 1, 1);
        addField(fatherFirstName, "Имя отца", 2, 4, 1, 1);
        addField(motherMiddleName, "Отчество матери", 0, 5, 1, 1);
        addField(fatherMiddleName, "Отчество отца", 2, 5, 1, 1);
        addField(motherSalary, "Зарплата матери", 0, 6, 1, 1);
        addField(fatherSalary, "Зарплата отца", 2, 6, 1, 1);
        addField(numberOfBrothers, "Количество братьев", 0, 7, 2, 1);
        addField(numberOfSisters, "Количество сестер", 0, 8, 2, 1);
    }

    private void addField(JTextField textField, String name, int gridX, int gridY, int gridWidth, int gridHeight) {
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints labelGbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        GridBagConstraints textFieldGbc = new GridBagConstraints(gridX + gridWidth, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        add(label, labelGbc);
        add(textField, textFieldGbc);
    }

    private void addJButton() {
        JButton button = new JButton("Add student");
        Insets insets = new Insets(1, 1, 1, 1);
        GridBagConstraints gbc = new GridBagConstraints(0, 9, 4, 1, 1.0, 1.0,
                                                        GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
                                                        insets, 0, 0);
        add(button, gbc);
    }
}
