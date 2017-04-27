package tableListener;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import studentDataBase.Student;
import studentDataBase.StudentDataBase;
import studentTable.TableModel;
import studentTable.TableWithPaging;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by shund on 25.04.2017.
 */
public class FileHandler {
    public static final String TAG_TABLE = "Table";
    public static final String TAG_STUDENT = "Student";
    public static final String TAG_STUDENT_SN = "StudentSurname";
    public static final String TAG_STUDENT_FN = "StudentFirstName";
    public static final String TAG_STUDENT_PT = "StudentPatronymic";
    public static final String TAG_FATHER_SN = "FatherSurname";
    public static final String TAG_FATHER_FN = "FatherFirstName";
    public static final String TAG_FATHER_PT = "FatherPatronymic";
    public static final String TAG_FATHER_SALARY = "FatherSalary";
    public static final String TAG_MOTHER_SN = "MotherSurname";
    public static final String TAG_MOTHER_FN = "MotherFirstName";
    public static final String TAG_MOTHER_PT = "MotherPatronymic";
    public static final String TAG_MOTHER_SALARY = "MotherSalary";
    public static final String TAG_BROTHERS_AMOUNT = "BrothersAmount";
    public static final String TAG_SISTERS_AMOUNT = "SistersAmount";

    private TableWithPaging tableWithPaging;
    private Element element;

    public FileHandler(TableWithPaging tableWithPaging) {
        this.tableWithPaging = tableWithPaging;
    }

    public void saveFile() throws ParserConfigurationException, TransformerException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(tableWithPaging) == JFileChooser.APPROVE_OPTION) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            element = document.createElement(TAG_TABLE);
            document.appendChild(element);

            List<Student> studentList = tableWithPaging.getStudentDataBase().getStudents();

            for (Student student : studentList) {
                Element newStudent = document.createElement(TAG_STUDENT);

                Element newStudentSN = document.createElement(TAG_STUDENT_SN);
                newStudentSN.appendChild(document.createTextNode(student.getSurname()));
                newStudent.appendChild(newStudentSN);

                Element newStudentFN = document.createElement(TAG_STUDENT_FN);
                newStudentFN.appendChild(document.createTextNode(student.getFirstName()));
                newStudent.appendChild(newStudentFN);

                Element newStudentPT = document.createElement(TAG_STUDENT_PT);
                newStudentPT.appendChild(document.createTextNode(student.getPatronymic()));
                newStudent.appendChild(newStudentPT);

                Element newFatherSN = document.createElement(TAG_FATHER_SN);
                newFatherSN.appendChild(document.createTextNode(student.getFather().getSurname()));
                newStudent.appendChild(newFatherSN);

                Element newFatherFN = document.createElement(TAG_FATHER_FN);
                newFatherFN.appendChild(document.createTextNode(student.getFather().getFirstName()));
                newStudent.appendChild(newFatherFN);

                Element newFatherPT = document.createElement(TAG_FATHER_PT);
                newFatherPT.appendChild(document.createTextNode(student.getFather().getPatronymic()));
                newStudent.appendChild(newFatherPT);

                Element newFatherSalary = document.createElement(TAG_FATHER_SALARY);
                newFatherSalary.appendChild(document.createTextNode(String.valueOf(student.getFather().getSalary())));
                newStudent.appendChild(newFatherSalary);

                Element newMotherSN = document.createElement(TAG_MOTHER_SN);
                newMotherSN.appendChild(document.createTextNode(student.getMother().getSurname()));
                newStudent.appendChild(newMotherSN);

                Element newMotherFN = document.createElement(TAG_MOTHER_FN);
                newMotherFN.appendChild(document.createTextNode(student.getMother().getFirstName()));
                newStudent.appendChild(newMotherFN);

                Element newMotherPT = document.createElement(TAG_MOTHER_PT);
                newMotherPT.appendChild(document.createTextNode(student.getMother().getPatronymic()));
                newStudent.appendChild(newMotherPT);

                Element newMotherSalary = document.createElement(TAG_MOTHER_SALARY);
                newMotherSalary.appendChild(document.createTextNode(String.valueOf(student.getMother().getSalary())));
                newStudent.appendChild(newMotherSalary);

                Element newBrothersAmount = document.createElement(TAG_BROTHERS_AMOUNT);
                newBrothersAmount.appendChild(document.createTextNode(String.valueOf(student.getBrothersAmount())));
                newStudent.appendChild(newBrothersAmount);

                Element newSistersAmount = document.createElement(TAG_SISTERS_AMOUNT);
                newSistersAmount.appendChild(document.createTextNode(String.valueOf(student.getSistersAmount())));
                newStudent.appendChild(newSistersAmount);

                element.appendChild(newStudent);

                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult result = new StreamResult(new File(fileChooser.getSelectedFile() + ".xml"));
                transformer.transform(domSource, result);
            }
        }
    }

    public void openFile() throws ParserConfigurationException, SAXException, IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(tableWithPaging) == JFileChooser.APPROVE_OPTION) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(fileChooser.getSelectedFile().getPath(), new Parser());
        }
    }

    class Parser extends DefaultHandler {
        private Student student;
        private List<Student> studentList;
        private String tagName;

        public Parser() {
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            tableWithPaging.setStudentDataBase(new StudentDataBase());
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            tableWithPaging.getStudentDataBase().setStudents(studentList);
            tableWithPaging.setTableModel(new TableModel(studentList));

            tableWithPaging.setRecodesNumber(5);
            tableWithPaging.setPagesNumber(1);
            tableWithPaging.setCurrentPage(1);

            tableWithPaging.getToolBar().setVisible(true);
            tableWithPaging.updateTable();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagName = qName;
            if (qName.equals(TAG_TABLE)) {
                studentList = new ArrayList<Student>();
            } else if (qName.equals(TAG_STUDENT)) {
                student = new Student();
                studentList.add(student);
            }
            super.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName.equals(TAG_STUDENT_SN)) {
                student.setSurname(new String(ch, start, length));
            } else if (tagName.equals(TAG_STUDENT_FN)) {
                student.setFirstName(new String(ch, start, length));
            } else if (tagName.equals(TAG_STUDENT_PT)) {
                student.setPatronymic(new String(ch, start, length));
            } else if (tagName.equals(TAG_FATHER_SN)) {
                student.getFather().setSurname(new String(ch, start, length));
            } else if (tagName.equals(TAG_FATHER_FN)) {
                student.getFather().setFirstName(new String(ch, start, length));
            } else if (tagName.equals(TAG_FATHER_PT)) {
                student.getFather().setPatronymic(new String(ch, start, length));
            } else if (tagName.equals(TAG_FATHER_SALARY)) {
                student.getFather().setSalary(Double.parseDouble(new String(ch, start, length)));
            } else if (tagName.equals(TAG_MOTHER_SN)) {
                student.getMother().setSurname(new String(ch, start, length));
            } else if (tagName.equals(TAG_MOTHER_FN)) {
                student.getMother().setFirstName(new String(ch, start, length));
            } else if (tagName.equals(TAG_MOTHER_PT)) {
                student.getMother().setPatronymic(new String(ch, start, length));
            } else if (tagName.equals(TAG_MOTHER_SALARY)) {
                student.getMother().setSalary(Double.parseDouble(new String(ch, start, length)));
            } else if (tagName.equals(TAG_BROTHERS_AMOUNT)) {
                student.setBrothersAmount(Integer.parseInt(new String(ch, start, length)));
            } else if (tagName.equals(TAG_SISTERS_AMOUNT)) {
                student.setSistersAmount(Integer.parseInt(new String(ch, start, length)));
            }
            super.characters(ch, start, length);
        }

    }

}
