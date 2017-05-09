package tableListener;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import studentDataBase.Father;
import studentDataBase.Mother;
import studentDataBase.Student;
import studentDataBase.StudentDataBase;
import tableController.TableController;

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
    public static final String TAG_FATHER = "Father";
    public static final String TAG_MOTHER = "Mother";
    public static final String TAG_SURNAME = "Surname";
    public static final String TAG_FIRST_NAME = "FirstName";
    public static final String TAG_PATRONYMIC = "Patronymic";
    public static final String TAG_SALARY = "Salary";
    public static final String TAG_BROTHERS_AMOUNT = "BrothersAmount";
    public static final String TAG_SISTERS_AMOUNT = "SistersAmount";

    private TableController tableController;
    private Element element;

    public FileHandler(TableController tableController) {
        this.tableController = tableController;
    }

    public void saveFile() throws ParserConfigurationException, TransformerException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            element = document.createElement(TAG_TABLE);
            document.appendChild(element);

            List<Student> studentList = tableController.getStudentDataBase().getStudents();

            for (Student student : studentList) {
                Element newStudent = document.createElement(TAG_STUDENT);

                Element newStudentSN = document.createElement(TAG_SURNAME);
                newStudentSN.appendChild(document.createTextNode(student.getSurname()));
                newStudent.appendChild(newStudentSN);

                Element newStudentFN = document.createElement(TAG_FIRST_NAME);
                newStudentFN.appendChild(document.createTextNode(student.getFirstName()));
                newStudent.appendChild(newStudentFN);

                Element newStudentPT = document.createElement(TAG_PATRONYMIC);
                newStudentPT.appendChild(document.createTextNode(student.getPatronymic()));
                newStudent.appendChild(newStudentPT);

                Element newFather = document.createElement(TAG_FATHER);
                newStudent.appendChild(newFather);

                Element newFatherSN = document.createElement(TAG_SURNAME);
                newFatherSN.appendChild(document.createTextNode(student.getFather().getSurname()));
                newFather.appendChild(newFatherSN);

                Element newFatherFN = document.createElement(TAG_FIRST_NAME);
                newFatherFN.appendChild(document.createTextNode(student.getFather().getFirstName()));
                newFather.appendChild(newFatherFN);

                Element newFatherPT = document.createElement(TAG_PATRONYMIC);
                newFatherPT.appendChild(document.createTextNode(student.getFather().getPatronymic()));
                newFather.appendChild(newFatherPT);

                Element newFatherSalary = document.createElement(TAG_SALARY);
                newFatherSalary.appendChild(document.createTextNode(String.valueOf(student.getFather().getSalary())));
                newFather.appendChild(newFatherSalary);

                Element newMother = document.createElement(TAG_MOTHER);
                newStudent.appendChild(newMother);

                Element newMotherSN = document.createElement(TAG_SURNAME);
                newMotherSN.appendChild(document.createTextNode(student.getMother().getSurname()));
                newMother.appendChild(newMotherSN);

                Element newMotherFN = document.createElement(TAG_FIRST_NAME);
                newMotherFN.appendChild(document.createTextNode(student.getMother().getFirstName()));
                newMother.appendChild(newMotherFN);

                Element newMotherPT = document.createElement(TAG_PATRONYMIC);
                newMotherPT.appendChild(document.createTextNode(student.getMother().getPatronymic()));
                newMother.appendChild(newMotherPT);

                Element newMotherSalary = document.createElement(TAG_SALARY);
                newMotherSalary.appendChild(document.createTextNode(String.valueOf(student.getMother().getSalary())));
                newMother.appendChild(newMotherSalary);

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

    public boolean openFile() throws ParserConfigurationException, SAXException, IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(fileChooser.getSelectedFile().getPath(), new Parser());
            return true;
        }

        return false;
    }

    class Parser extends DefaultHandler {
        private Student student;
        private List<Student> studentList;
        private String currentTagName;
        private String previousTagName;

        public Parser() {
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            tableController.getStudentDataBase().setStudents(studentList);

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(uri);
            currentTagName = qName;
            if (qName.equals(TAG_TABLE)) {
                studentList = new ArrayList<Student>();
            } else if (qName.equals(TAG_STUDENT)) {
                student = new Student();
                studentList.add(student);
                previousTagName = qName;
            } else if (qName.equals(TAG_FATHER)) {
                previousTagName = qName;
            } else if (qName.equals(TAG_MOTHER)) {
                previousTagName = qName;
            }
            super.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentTagName.equals(TAG_SURNAME) && !previousTagName.equals(TAG_MOTHER) && !previousTagName.equals(TAG_FATHER)) {
                student.setSurname(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_FIRST_NAME) && !previousTagName.equals(TAG_MOTHER) && !previousTagName.equals(TAG_FATHER)) {
                student.setFirstName(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_PATRONYMIC) && !previousTagName.equals(TAG_MOTHER) && !previousTagName.equals(TAG_FATHER)) {
                student.setPatronymic(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_SURNAME) && previousTagName.equals(TAG_FATHER)) {
                student.getFather().setSurname(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_FIRST_NAME) && previousTagName.equals(TAG_FATHER)) {
                student.getFather().setFirstName(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_PATRONYMIC) && previousTagName.equals(TAG_FATHER)) {
                student.getFather().setPatronymic(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_SALARY) && previousTagName.equals(TAG_FATHER)) {
                student.getFather().setSalary(Double.parseDouble(new String(ch, start, length)));
            } else if (currentTagName.equals(TAG_SURNAME) && previousTagName.equals(TAG_MOTHER)) {
                student.getMother().setSurname(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_FIRST_NAME) && previousTagName.equals(TAG_MOTHER)) {
                student.getMother().setFirstName(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_PATRONYMIC) && previousTagName.equals(TAG_MOTHER)) {
                student.getMother().setPatronymic(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_SALARY) && previousTagName.equals(TAG_MOTHER)) {
                student.getMother().setSalary(Double.parseDouble(new String(ch, start, length)));
            } else if (currentTagName.equals(TAG_BROTHERS_AMOUNT)) {
                student.setBrothersAmount(Integer.parseInt(new String(ch, start, length)));
            } else if (currentTagName.equals(TAG_SISTERS_AMOUNT)) {
                student.setSistersAmount(Integer.parseInt(new String(ch, start, length)));
            }
            super.characters(ch, start, length);
        }

    }

}
