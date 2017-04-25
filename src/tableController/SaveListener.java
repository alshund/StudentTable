package tableController;

import javafx.stage.FileChooser;
import studentTable.TableWithPaging;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 25.04.2017.
 */
public class SaveListener implements ActionListener {
    TableWithPaging tableWithPaging;

    public SaveListener(TableWithPaging tableWithPaging){
        this.tableWithPaging = tableWithPaging;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        FileHandler fileHandler = new FileHandler(tableWithPaging);
        try {
            fileHandler.saveFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
