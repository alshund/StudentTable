import javax.swing.*;
import java.awt.*;

/**
 * Created by shund on 09.04.2017.
 */
public class MainWindow {
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private TableView tableView;

    private final int FILE_MENU = 0;
    private final int EDIT_MENU = 1;
    private final int NEW_FILE = 0;
    private final int OPEN_FIE = 1;
    private final int SAVE_FILE = 2;
    private final int EXIT_FILE = 3;
    private final int ADD_EDIT = 0;
    private final int SEARCH_EDIT = 1;
    private final int DELETE_EDIT = 2;

    public MainWindow() {
        mainFrame = new JFrame("Состав семьи студентов");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        menuBar = addJMenuBar();
        mainFrame.setJMenuBar(menuBar);

        toolBar = addJToolBar();
        mainFrame.add(toolBar, BorderLayout.NORTH);

        tableView = new TableView();
        mainFrame.add(tableView, BorderLayout.CENTER);

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
        menu.add(newItem);
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);
    }

    private void setJEditItem(JMenu menu) {
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem searchItem = new JMenuItem("Search");
        JMenuItem deleteItem = new JMenuItem("Delete");
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
        JButton search = new JButton("Search");
        JButton add = new JButton("Add");
        JButton delete = new JButton("Delete");
        tool.add(search);
        tool.add(add);
        tool.add(delete);
        tool.setFloatable(false);
        tool.setVisible(false);
    }

    private void addListener(){
        NewTableListener newTableListener = new NewTableListener(toolBar, tableView);
        menuBar.getMenu(FILE_MENU).getItem(NEW_FILE).addActionListener(newTableListener);
        AddStudentListener addStudentListener = new AddStudentListener(mainFrame, tableView);
        menuBar.getMenu(EDIT_MENU).getItem(ADD_EDIT).addActionListener(addStudentListener);
    }

    public static void main(String[] arg) {
        new MainWindow();
    }
}
