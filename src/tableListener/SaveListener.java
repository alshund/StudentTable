package tableListener;

import studentTable.TableWithPaging;
import tableController.TableController;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shund on 25.04.2017.
 */
public class SaveListener implements ActionListener {
    private TableController tableController;

    public SaveListener(TableController tableController) {
        this.tableController = tableController;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        FileHandler fileHandler = new FileHandler(tableController);
        try {
            fileHandler.saveFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
