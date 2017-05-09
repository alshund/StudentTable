package studentTable.dialog;

import selectStrategy.SelectStrategy;
import selectStrategy.algoritms.*;
import tableController.TableController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 25.04.2017.
 */
public class DeleteStudentDialog {
    JDialog deleteStudentDialog;
    SearchPanel searchPanel;
    TableController tableController;

    public DeleteStudentDialog(JFrame mainFrame, TableController tableController) {
        this.tableController = tableController;

        deleteStudentDialog = new JDialog(mainFrame, "Delete student", true);
        deleteStudentDialog.setSize(350, 650);
        deleteStudentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        deleteStudentDialog.setLayout(new BorderLayout());
        deleteStudentDialog.setLocationRelativeTo(mainFrame);

        searchPanel = new SearchPanel();

        deleteStudentDialog.add(searchPanel.getSearchPanel(), BorderLayout.CENTER);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        deleteStudentDialog.add(deleteButton, BorderLayout.SOUTH);

        deleteStudentDialog.setVisible(true);
    }

    class DeleteButtonListener implements ActionListener {

        public DeleteButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            SelectStrategy selectStrategy = null;
            boolean found = false;
            int recodesAmount = tableController.getDataBaseSize();
            for (JRadioButton radioButton : searchPanel.getRadioButtonList()) {
                if (radioButton.isSelected()) {
                    if (radioButton.getName().equals("Student")) {
                        selectStrategy = new StudentNameSelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("Father")) {
                        selectStrategy = new FatherNameSelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("Mother")) {
                        selectStrategy = new MotherNameSelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("FatherSalary")) {
                        selectStrategy = new FatherSalarySelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("MotherSalary")) {
                        selectStrategy = new MotherSalarySelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("BrotherAmount")) {
                        selectStrategy = new BrotherAmountSelect(searchPanel);
                        break;
                    } else if (radioButton.getName().equals("SisterAmount")) {
                        selectStrategy = new SisterAmountSelect(searchPanel);
                        break;
                    }
                }
            }
            tableController.setSearchStrategy(selectStrategy.execute());
            if (tableController.getSearchStrategy() != null) {
                found = true;
                tableController.delete();
                tableController.setSearchStrategy(null);
            }
            if (found) {
                recodesAmount = recodesAmount - tableController.getDataBaseSize();
                JOptionPane.showMessageDialog(deleteStudentDialog, "The deletion is complete. Number of deleted records: " + recodesAmount, "Delete", JOptionPane.INFORMATION_MESSAGE);
                deleteStudentDialog.dispose();
            }
        }
    }
}
