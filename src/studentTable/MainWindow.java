package studentTable;

import constants.*;
import constants.Window;
import studentDataBase.StudentDataBase;
import tableController.TableController;
import tableListener.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 09.04.2017.
 */
public class MainWindow {
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private TableWithPaging tableWithPaging;
    private TableController tableController;

    public MainWindow(TableController tableController) {
        this.tableController = tableController;
        mainFrame = new JFrame("Состав семьи студентов");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setSize(JFrame.MAXIMIZED_HORIZ, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        menuBar = addJMenuBar();
        mainFrame.setJMenuBar(menuBar);

        tableWithPaging = new TableWithPaging(tableController);

        toolBar = addJToolBar();
        mainFrame.add(toolBar, BorderLayout.NORTH);

        mainFrame.add(tableWithPaging.getTableWithPaging(), BorderLayout.CENTER);

        addListener();

        mainFrame.setVisible(true);
        mainFrame.toFront();
        mainFrame.requestFocus();
    }

    private JMenuBar addJMenuBar() {
        JMenuBar menu = new JMenuBar();
        menu.add(addJFileMenu("File"));
        menu.add(addJEditMenu("Edit"));
        return menu;
    }

    private JMenu addJFileMenu(String name) {
        JMenu menu = new JMenu(name);
        setJFileItem(menu);
        return menu;
    }

    private JMenu addJEditMenu(String name) {
        JMenu menu = new JMenu(name);
        setJEditItem(menu);
        return menu;
    }

    private void setJFileItem(JMenu menu) {
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        saveItem.setEnabled(false);

        menu.add(newItem);
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);
    }

    private void setJEditItem(JMenu menu) {
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem searchItem = new JMenuItem("Search");
        JMenuItem deleteItem = new JMenuItem("Delete");

        addItem.setEnabled(false);
        searchItem.setEnabled(false);
        deleteItem.setEnabled(false);

        menu.add(addItem);
        menu.add(searchItem);
        menu.add(deleteItem);
    }

    private JToolBar addJToolBar() {
        JToolBar tool = new JToolBar("Work with table", JToolBar.HORIZONTAL);
        setJToolBar(tool);
        return tool;
    }

    private void setJToolBar(JToolBar tool) {
        JButton add = new JButton();
        JButton search = new JButton();
        JButton delete = new JButton();

        setIcon(add, "addition.png");
        setIcon(search, "search.png");
        setIcon(delete, "delete.png");

        add.addActionListener(new AdditionStudentListener(mainFrame, tableController));
        search.addActionListener(new SearchStudentListener(mainFrame, tableController));
        delete.addActionListener(new DeleteStudentListener(mainFrame, tableController));

        tool.add(add);
        tool.add(search);
        tool.add(delete);

        tool.setFloatable(false);
        tool.setVisible(false);
    }

    private void setIcon(JButton button, String name) {
        ImageIcon imageIcon = new ImageIcon("Resource/" + name);
        button.setIcon(imageIcon);
    }

    private void addListener() {
        NewTableListener newTableListener = new NewTableListener(menuBar, toolBar, tableWithPaging, tableController);
        menuBar.getMenu(Window.FILE_MENU).getItem(Window.NEW_FILE).addActionListener(newTableListener);

        OpenListener openListener = new OpenListener(menuBar, toolBar, tableController);
        menuBar.getMenu(Window.FILE_MENU).getItem(Window.OPEN_FIE).addActionListener(openListener);

        SaveListener saveListener = new SaveListener(tableController);
        menuBar.getMenu(Window.FILE_MENU).getItem(Window.SAVE_FILE).addActionListener(saveListener);

        menuBar.getMenu(Window.FILE_MENU).getItem(Window.EXIT_FILE).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        AdditionStudentListener additionStudentListener = new AdditionStudentListener(mainFrame, tableController);
        menuBar.getMenu(Window.EDIT_MENU).getItem(Window.ADD_EDIT).addActionListener(additionStudentListener);

        SearchStudentListener searchStudentListener = new SearchStudentListener(mainFrame, tableController);
        menuBar.getMenu(Window.EDIT_MENU).getItem(Window.SEARCH_EDIT).addActionListener(searchStudentListener);

        DeleteStudentListener deleteStudentListener = new DeleteStudentListener(mainFrame, tableController);
        menuBar.getMenu(Window.EDIT_MENU).getItem(Window.DELETE_EDIT).addActionListener(deleteStudentListener);
    }
}
