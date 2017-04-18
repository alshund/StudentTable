import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by shund on 11.04.2017.
 */
public class TableWithPaging extends JComponent {
    private JTable table;
    private TableModel tableModel;
    private StudentDataBase studentDataBase;
    private int recodesNumber;
    private int currentPage;

    public TableWithPaging() {
        setLayout(new BorderLayout());

        recodesNumber = 2;
        currentPage = 1;

        table = new JTable();
        tableModel = new TableModel(new ArrayList<Student>());
        studentDataBase = new StudentDataBase();

        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(addJToolBar(), BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JToolBar addJToolBar() {
        JToolBar toolBar = new JToolBar("Paging", JToolBar.HORIZONTAL);
        setJToolBar(toolBar);
        return toolBar;
    }

    private void setJToolBar(JToolBar toolBar) {
        toolBar.setFloatable(false);

        SpinnerNumberModel spmRecodesNumber = new SpinnerNumberModel(10, 1, null, 1);
        JSpinner spRecodesNumber = new JSpinner(spmRecodesNumber);
        spRecodesNumber.setMaximumSize(new Dimension(100, 100));

        JButton btRecodesNumber = new JButton("Change recodes number");
        btRecodesNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                recodesNumber = (int) spRecodesNumber.getValue();
                currentPage = studentDataBase.getStudents().size() > recodesNumber ? ((int) studentDataBase.getStudents().size()/recodesNumber) : 1;
//                currentPage = (int) studentDataBase.getStudents().size()/recodesNumber;
                System.out.println(currentPage);
                List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
                table.setModel(new TableModel(page));
            }
        });

        JButton btFirstPage = new JButton("First page");
        btFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });

        JButton btPreviousPage = new JButton("Previous page");
        btPreviousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });

        JButton btNextPage = new JButton("Next page");
        btNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });

        JButton btLastPage = new JButton("Last page");
        btLastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(btFirstPage);
        buttonGroup.add(btPreviousPage);
        buttonGroup.add(btNextPage);
        buttonGroup.add(btLastPage);


        toolBar.add(spRecodesNumber);
        toolBar.add(btRecodesNumber);
        toolBar.addSeparator();
        toolBar.add(btFirstPage);
        toolBar.add(btPreviousPage);
        toolBar.add(btNextPage);
        toolBar.add(btLastPage);
    }

    public void updateTable() {
        List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
        table.setModel(new TableModel(page));
        if (recodesNumber == page.size()){
            currentPage++;
        }
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public StudentDataBase getStudentDataBase() {
        return studentDataBase;
    }

    public void setStudentDataBase(StudentDataBase studentDataBase) {
        this.studentDataBase = studentDataBase;
    }
}
