import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int pagesNumber;
    private int currentPage;
    private JToolBar toolBar;
    private SpinnerNumberModel spmPageChange;
    private SpinnerNumberModel spmRecodesNumber;

    public TableWithPaging() {
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        toolBar = new JToolBar();
        setPaging(toolBar);
        add(toolBar, BorderLayout.SOUTH);
    }

    private void setPaging(JToolBar toolBar) {
        toolBar.setFloatable(false);
        toolBar.setVisible(false);

        spmRecodesNumber = new SpinnerNumberModel(5, 1, null, 1);
        JSpinner spRecodesNumber = new JSpinner(spmRecodesNumber);
        spRecodesNumber.setMaximumSize(new Dimension(100, 100));

        spmPageChange = new SpinnerNumberModel(1, 1, 1, 1);
        JSpinner spPageChange = new JSpinner(spmPageChange);
        spPageChange.setMaximumSize(new Dimension(100, 100));

        JButton btRecodesNumber = new JButton("Change recodes number");
        btRecodesNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setRecodesNumber((int) spRecodesNumber.getValue());
                if (!studentDataBase.getStudents().isEmpty()) {
                    setPagesNumber((int) Math.ceil((double) studentDataBase.getStudents().size() / recodesNumber));
                }
                if (currentPage > pagesNumber) {
                    setCurrentPage(pagesNumber);
                }
                List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
                tableModel.setStudents(page);
                tableModel.fireTableDataChanged();
            }
        });

        JButton btFirstPage = new JButton("First page");
        btFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage((int) spmPageChange.getMinimum());
                updateTable();
            }
        });

        JButton btPreviousPage = new JButton("Previous page");
        btPreviousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (currentPage != 1) {
                    setCurrentPage(currentPage--);
                    updateTable();
                }
            }
        });

        JButton btNextPage = new JButton("Next page");
        btNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (currentPage != pagesNumber) {
                    setCurrentPage(currentPage++);
                    updateTable();
                }
            }
        });

        JButton btLastPage = new JButton("Last page");
        btLastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage((int) spmPageChange.getMaximum());
                updateTable();
            }
        });

        JButton btPageChange = new JButton("Change page");
        btPageChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                currentPage = (int) spmPageChange.getValue();
                List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
                tableModel.setStudents(page);
                tableModel.fireTableDataChanged();
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
        toolBar.addSeparator();
        toolBar.add(spPageChange);
        toolBar.add(btPageChange);
    }

    public void updateTable() {
        if (isNewPage()) {
            setPagesNumber(++pagesNumber);
            setCurrentPage(pagesNumber);
        }
        List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
        tableModel.setStudents(page);
        tableModel.fireTableDataChanged();
    }

    private boolean isNewPage() {
        return (pagesNumber - 1) * recodesNumber + recodesNumber < studentDataBase.getStudents().size();
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
        table.setModel(tableModel);
    }

    public StudentDataBase getStudentDataBase() {
        return studentDataBase;
    }

    public void setStudentDataBase(StudentDataBase studentDataBase) {
        this.studentDataBase = studentDataBase;
    }

    public int getRecodesNumber() {
        return recodesNumber;
    }

    public void setRecodesNumber(int recodesNumber) {
        this.recodesNumber = recodesNumber;
        spmRecodesNumber.setValue(recodesNumber);
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        spmPageChange.setMaximum(pagesNumber);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        spmPageChange.setValue(currentPage);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }
}
