import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by shund on 22.04.2017.
 */
public class SearchStudentDialog {
    private JDialog searchStudentDialog;
    private StudentDataBase studentDataBase;

    public SearchStudentDialog(JFrame mainFrame, TableWithPaging tableWithPaging){
        searchStudentDialog = new JDialog(mainFrame, "Search student", true);
        searchStudentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        searchStudentDialog.setSize(800, 400);
        searchStudentDialog.setLayout(new BorderLayout());
        searchStudentDialog.setLocationRelativeTo(tableWithPaging);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        JRadioButton student = new JRadioButton("Student");
        addComponent(searchPanel, student, 0, 0, 1, 1);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addComponent(panel, searchPanel, 0, 0, 1.0);

        TableWithPaging searchTable = new TableWithPaging();
        searchTable.setTableModel(new TableModel(new ArrayList<Student>()));
        searchTable.getToolBar().setVisible(true);
        addComponent(panel, searchTable, 1, 0, 2.0);


        searchStudentDialog.add(panel, BorderLayout.CENTER);




        searchStudentDialog.setVisible(true);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, double weightX) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, 1, 1, weightX, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, int gridWidth, int gridHeight) {
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }
}
