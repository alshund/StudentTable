package tableListener;

import org.xml.sax.SAXException;
import studentTable.MainWindow;
import studentTable.TableWithPaging;
import tableController.TableController;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by shund on 25.04.2017.
 */
public class OpenListener implements ActionListener {
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private TableController tableController;

    public OpenListener(JMenuBar menuBar, JToolBar toolBar, TableController tableController) {
        this.menuBar = menuBar;
        this.toolBar = toolBar;
        this.tableController = tableController;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        boolean open = false;
        FileHandler fileHandler = new FileHandler(tableController);
        try {
            open = fileHandler.openFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!toolBar.isVisible() && open) {
            toolBar.setVisible(true);

            menuBar.getMenu(MainWindow.FILE_MENU).getItem(MainWindow.SAVE_FILE).setEnabled(true);

            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.ADD_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.SEARCH_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.DELETE_EDIT).setEnabled(true);
        }
    }
}
