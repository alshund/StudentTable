package studentTable;

import studentDataBase.Student;
import studentDataBase.StudentDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        toolBar.setLayout(new BorderLayout());
        setPaging(toolBar);
        add(toolBar, BorderLayout.SOUTH);
    }

    private void setPaging(JToolBar toolBar) {
        toolBar.setFloatable(false);
        toolBar.setVisible(false);

        JPanel recodesChangerPanel = new JPanel();
        recodesChangerPanel.setLayout(new FlowLayout());

        spmRecodesNumber = new SpinnerNumberModel(5, 1, null, 1);
        JSpinner spRecodesNumber = new JSpinner(spmRecodesNumber);
        Dimension dimensionRN = spRecodesNumber.getPreferredSize();
        dimensionRN.width = 50;
        dimensionRN.height = 32;
        spRecodesNumber.setPreferredSize(dimensionRN);


        spmPageChange = new SpinnerNumberModel(1, 1, 1, 1);
        JSpinner spPageChange = new JSpinner(spmPageChange);
        Dimension dimensionPC = spRecodesNumber.getPreferredSize();
        dimensionPC.width = 50;
        dimensionPC.height = 32;
        spPageChange.setPreferredSize(dimensionRN);

        JButton btRecodesNumber = new JButton("Change recodes");
        setIcon(btRecodesNumber, "changeRecodesAmount.png");
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

        recodesChangerPanel.add(spRecodesNumber);
        recodesChangerPanel.add(btRecodesNumber);

        JPanel pageStatePanel = new JPanel();
        pageStatePanel.setLayout(new GridBagLayout());

        JButton btFirstPage = new JButton();
        setIcon(btFirstPage, "firstPage.png");
        btFirstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage((int) spmPageChange.getMinimum());
                updateTable();
            }
        });

        JButton btPreviousPage = new JButton();
        setIcon(btPreviousPage, "previousPage.png");
        btPreviousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (currentPage != 1) {
                    setCurrentPage(--currentPage);
                    updateTable();
                }
            }
        });

        JButton btNextPage = new JButton();
        setIcon(btNextPage, "nextPage.png");
        btNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (currentPage != pagesNumber) {
                    setCurrentPage(++currentPage);
                    updateTable();
                }
            }
        });

        JButton btLastPage = new JButton();
        setIcon(btLastPage, "lastPage.png");
        btLastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage((int) spmPageChange.getMaximum());
                updateTable();
            }
        });

        addComponent(pageStatePanel, btFirstPage, 0, 0, 1, 1);
        addComponent(pageStatePanel, btPreviousPage, GridBagConstraints.RELATIVE, 0, 1, 1);
        addComponent(pageStatePanel, btNextPage, GridBagConstraints.RELATIVE, 0, 1, 1);
        addComponent(pageStatePanel, btLastPage, GridBagConstraints.RELATIVE, 0, 1, 1);

        JPanel pageChangerPanel = new JPanel();
        pageChangerPanel.setLayout(new FlowLayout());

        JButton btPageChange = new JButton("Change page");
        setIcon(btPageChange, "changePage.png");
        btPageChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                currentPage = (int) spmPageChange.getValue();
                List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
                tableModel.setStudents(page);
                tableModel.fireTableDataChanged();
            }
        });

        pageChangerPanel.add(btPageChange);
        pageChangerPanel.add(spPageChange);

        toolBar.add(recodesChangerPanel, BorderLayout.WEST);
        toolBar.add(pageStatePanel, BorderLayout.CENTER);
        toolBar.add(pageChangerPanel, BorderLayout.EAST);
    }

    private void setIcon(JButton button, String name) {
        ImageIcon imageIcon = new ImageIcon("Resource/" + name);
        button.setIcon(imageIcon);
    }

    private void addComponent(JComponent container, JComponent component, int gridX, int gridY, int gridWidth, int gridHeight) {
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                insets, 0, 0);
        container.add(component, gbc);
    }

    public void updateTable() {
        if (isNewPage()) {
            setPagesNumber((int) Math.ceil((double) studentDataBase.getStudents().size() / recodesNumber));
            setCurrentPage(pagesNumber);
        } else {
            setPagesNumber((Integer) spmPageChange.getMinimum());
            setCurrentPage(pagesNumber);
        }
        List<Student> page = studentDataBase.getPage(currentPage, recodesNumber);
        tableModel.setStudents(page);
        tableModel.fireTableDataChanged();
    }

    private boolean isNewPage() {
        return (pagesNumber - 1) * recodesNumber + recodesNumber <= studentDataBase.getStudents().size();
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
