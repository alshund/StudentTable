package studentTable;

import tableController.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

/**
 * Created by shund on 09.04.2017.
 */
public class MainWindow {
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private TableWithPaging tableWithPaging;

    static public final int FILE_MENU = 0;
    static public final int EDIT_MENU = 1;
    static public final int NEW_FILE = 0;
    static public final int OPEN_FIE = 1;
    static public final int SAVE_FILE = 2;
    static public final int EXIT_FILE = 3;
    static public final int ADD_EDIT = 0;
    static public final int SEARCH_EDIT = 1;
    static public final int DELETE_EDIT = 2;

    public MainWindow() {
        mainFrame = new JFrame("Состав семьи студентов");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setSize(JFrame.MAXIMIZED_HORIZ, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        menuBar = addJMenuBar();
        mainFrame.setJMenuBar(menuBar);

        tableWithPaging = new TableWithPaging();

        toolBar = addJToolBar();
        mainFrame.add(toolBar, BorderLayout.NORTH);

        mainFrame.add(tableWithPaging, BorderLayout.CENTER);

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

    private void setJFileItem(JMenu menu)   {
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

        add.addActionListener(new AdditionStudentListener(mainFrame, tableWithPaging));
        search.addActionListener(new SearchStudentListener(mainFrame, tableWithPaging));
        delete.addActionListener(new DeleteStudentListener(mainFrame, tableWithPaging));

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

    private void addListener(){
        NewTableListener newTableListener = new NewTableListener(menuBar, toolBar, tableWithPaging);
        menuBar.getMenu(FILE_MENU).getItem(NEW_FILE).addActionListener(newTableListener);

        OpenListener openListener = new OpenListener(menuBar, toolBar, tableWithPaging);
        menuBar.getMenu(FILE_MENU).getItem(OPEN_FIE).addActionListener(openListener);

        SaveListener saveListener = new SaveListener(tableWithPaging);
        menuBar.getMenu(FILE_MENU).getItem(SAVE_FILE).addActionListener(saveListener);

        AdditionStudentListener additionStudentListener = new AdditionStudentListener(mainFrame, tableWithPaging);
        menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.ADD_EDIT).addActionListener(additionStudentListener);

        SearchStudentListener searchStudentListener = new SearchStudentListener(mainFrame, tableWithPaging);
        menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.SEARCH_EDIT).addActionListener(searchStudentListener);

        DeleteStudentListener deleteStudentListener = new DeleteStudentListener(mainFrame, tableWithPaging);
        menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.DELETE_EDIT).addActionListener(deleteStudentListener);
    }

    public static void main(String[] arg) {
        new MainWindow();
    }
}
