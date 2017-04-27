package tableListener;

import org.xml.sax.SAXException;
import studentTable.MainWindow;
import studentTable.TableWithPaging;

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
    private TableWithPaging tableWithPaging;

    public OpenListener(JMenuBar menuBar, JToolBar toolBar, TableWithPaging tableWithPaging) {
        this.menuBar = menuBar;
        this.toolBar = toolBar;
        this.tableWithPaging = tableWithPaging;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (!toolBar.isVisible()) {
            toolBar.setVisible(true);

            menuBar.getMenu(MainWindow.FILE_MENU).getItem(MainWindow.SAVE_FILE).setEnabled(true);

            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.ADD_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.SEARCH_EDIT).setEnabled(true);
            menuBar.getMenu(MainWindow.EDIT_MENU).getItem(MainWindow.DELETE_EDIT).setEnabled(true);
        }

        FileHandler fileHandler = new FileHandler(tableWithPaging);
        try {
            fileHandler.openFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
