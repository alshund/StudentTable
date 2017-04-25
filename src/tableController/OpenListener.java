package tableController;

import org.xml.sax.SAXException;
import studentTable.TableWithPaging;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by shund on 25.04.2017.
 */
public class OpenListener implements ActionListener {
    private TableWithPaging tableWithPaging;

    public OpenListener(TableWithPaging tableWithPaging) {
        this.tableWithPaging = tableWithPaging;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
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
