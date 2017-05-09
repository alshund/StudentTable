package studentTable;

import observe.Observer;
import studentDataBase.Student;
import tableController.TableController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by shund on 11.04.2017.
 */
public class TableWithPaging extends JComponent implements Observer {
    public static final int FIRST_PAGE = 1;

    private TableController tableController;

    private JTable table;
    private TableModel tableModel;

    private SpinnerNumberModel spmRecodesChanger;
    private SpinnerNumberModel spmPageChanger;

    private JToolBar toolBar;

    private JButton btChangeRecodesAmount;
    private JButton btFirstPage;
    private JButton btLastPage;
    private JButton btPreviousPage;
    private JButton btNextPage;
    private JButton btChangePagesAmount;

    public TableWithPaging(TableController tableController) {
        this.tableController = tableController;
        tableController.getStudentDataBase().addTable(this);
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        toolBar = new JToolBar();

        toolBar.setLayout(new BorderLayout());
        setPaging(toolBar);
        add(toolBar, BorderLayout.SOUTH);
        addListeners();
    }

    private void addListeners() {
        getBtChangeRecodesAmount().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tableController.changeRecodesAmount();
            }
        });

        getBtFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage(FIRST_PAGE);
                tableController.changePage(getCurrentPage(), getRecodesAmount());
            }
        });

        getBtPreviousPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (getCurrentPage() != FIRST_PAGE) {
                    int previousPage = getCurrentPage() - 1;
                    setCurrentPage(previousPage);
                }
                tableController.changePage(getCurrentPage(), getRecodesAmount());
            }
        });

        getBtNextPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (getCurrentPage() != getPagesAmount()) {
                    int nextPage = getCurrentPage() + 1;
                    setCurrentPage(nextPage);
                }
                tableController.changePage(getCurrentPage(), getRecodesAmount());
            }
        });

        getBtLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setCurrentPage(getPagesAmount());
                tableController.changePage(getCurrentPage(), getRecodesAmount());
            }
        });

        getBtChangePagesAmount().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tableController.changePage(getCurrentPage(), getRecodesAmount());
            }
        });
    }


    @Override
    public void repaintPaging(int dataBaseSize) {
        int recodesAmount = getRecodesAmount();
        int pagesAmount = (int) Math.ceil((double) dataBaseSize / recodesAmount);
        if (isNewPage(dataBaseSize)) {
            setPagesAmount(pagesAmount);
            setCurrentPage(pagesAmount);
        }
        tableController.changePage(getCurrentPage(), getRecodesAmount());
    }

    @Override
    public void refreshPaging(int dataBaseSize) {
        int recodesAmount = getRecodesAmount();
        if (!tableController.getStudentDataBase().getStudents().isEmpty()) {
            setPagesAmount((int) Math.ceil((double) dataBaseSize / recodesAmount));
        }
        if (getCurrentPage() > getPagesAmount()) {
            setCurrentPage(getPagesAmount());
        }
        tableController.changePage(getCurrentPage(), getRecodesAmount());
    }

    @Override
    public void updateData(List<Student> page) {
        setPage(page);
    }

    @Override
    public void createModel() {
        tableModel = new TableModel(new ArrayList<Student>());
        setTableModel(tableModel);
        getToolBar().setVisible(true);
    }



    private boolean isNewPage(int dataBaseSize) {
        int pagesAmount = getPagesAmount();
        int recodesAmount = getRecodesAmount();
        return recodesAmount <= dataBaseSize;
//        return (pagesAmount - 1) * recodesAmount + recodesAmount <= dataBaseSize;
    }


    private void setPaging(JToolBar toolBar) {
        toolBar.setFloatable(false);
        toolBar.setVisible(false);

        JPanel recodesChangerPanel = new JPanel();
        recodesChangerPanel.setLayout(new FlowLayout());

        spmRecodesChanger = new SpinnerNumberModel(5, 1, null, 1);
        JSpinner spRecodesNumber = new JSpinner(spmRecodesChanger);
        Dimension dimensionRN = spRecodesNumber.getPreferredSize();
        dimensionRN.width = 50;
        dimensionRN.height = 32;
        spRecodesNumber.setPreferredSize(dimensionRN);

        spmPageChanger = new SpinnerNumberModel(1, 1, 1, 1);
        JSpinner spPageChange = new JSpinner(spmPageChanger);
        Dimension dimensionPC = spRecodesNumber.getPreferredSize();
        dimensionPC.width = 50;
        dimensionPC.height = 32;
        spPageChange.setPreferredSize(dimensionRN);

        btChangeRecodesAmount = new JButton("Change recodes");
        setIcon(btChangeRecodesAmount, "changeRecodesAmount.png");

        recodesChangerPanel.add(spRecodesNumber);
        recodesChangerPanel.add(btChangeRecodesAmount);

        JPanel pageStatePanel = new JPanel();
        pageStatePanel.setLayout(new GridBagLayout());

        btFirstPage = new JButton();
        setIcon(btFirstPage, "firstPage.png");

        btPreviousPage = new JButton();
        setIcon(btPreviousPage, "previousPage.png");

        btNextPage = new JButton();
        setIcon(btNextPage, "nextPage.png");

        btLastPage = new JButton();
        setIcon(btLastPage, "lastPage.png");

        addComponent(pageStatePanel, btFirstPage, 0, 0, 1, 1);
        addComponent(pageStatePanel, btPreviousPage, GridBagConstraints.RELATIVE, 0, 1, 1);
        addComponent(pageStatePanel, btNextPage, GridBagConstraints.RELATIVE, 0, 1, 1);
        addComponent(pageStatePanel, btLastPage, GridBagConstraints.RELATIVE, 0, 1, 1);

        JPanel pageChangerPanel = new JPanel();
        pageChangerPanel.setLayout(new FlowLayout());

        btChangePagesAmount = new JButton("Change page");

        pageChangerPanel.add(btChangePagesAmount);
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

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JButton getBtChangeRecodesAmount() {
        return btChangeRecodesAmount;
    }

    public void setBtChangeRecodesAmount(JButton btChangeRecodesAmount) {
        this.btChangeRecodesAmount = btChangeRecodesAmount;
    }

    public JButton getBtFirstPage() {
        return btFirstPage;
    }

    public void setBtFirstPage(JButton btFirstPage) {
        this.btFirstPage = btFirstPage;
    }

    public JButton getBtLastPage() {
        return btLastPage;
    }

    public void setBtLastPage(JButton btLastPage) {
        this.btLastPage = btLastPage;
    }

    public JButton getBtPreviousPage() {
        return btPreviousPage;
    }

    public void setBtPreviousPage(JButton btPreviousPage) {
        this.btPreviousPage = btPreviousPage;
    }

    public JButton getBtNextPage() {
        return btNextPage;
    }

    public void setBtNextPage(JButton btNextPage) {
        this.btNextPage = btNextPage;
    }

    public JButton getBtChangePagesAmount() {
        return btChangePagesAmount;
    }

    public void setBtChangePagesAmount(JButton btChangePagesAmount) {
        this.btChangePagesAmount = btChangePagesAmount;
    }

    public void setPage(List<Student> page) {
        tableModel.setStudents(page);
        tableModel.fireTableDataChanged();
    }

    public int getRecodesAmount() {
        return (int) spmRecodesChanger.getValue();
    }

    public void setRecodesAmount(int recodesAmount) {
        spmRecodesChanger.setValue(recodesAmount);
    }

    public int getCurrentPage() {
        return (int) spmPageChanger.getValue();
    }

    public void setCurrentPage(int currentPage) {
        spmPageChanger.setValue(currentPage);
    }

    public int getPagesAmount() {
        return (int) spmPageChanger.getMaximum();
    }

    public void setPagesAmount(int pagesAmount) {
        spmPageChanger.setMaximum(pagesAmount);
    }



}
