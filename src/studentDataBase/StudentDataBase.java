package studentDataBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shund on 13.04.2017.
 */
public class StudentDataBase {
    private List<Student> students;

    public StudentDataBase() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> studentSnFnPtSearch(String surname, String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String studSN = "";
        String studFN = "";
        String studPN = "";
        for (Student student : students) {
            studSN = student.getSurname();
            studFN = student.getFirstName();
            studPN = student.getPatronymic();
            if (studSN.equals(surname) && studFN.equals(firstName) && studPN.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentSnFnSearch(String surname, String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String studSN = "";
        String studFN = "";
        for (Student student : students) {
            studSN = student.getSurname();
            studFN = student.getFirstName();
            if (studSN.equals(surname) && studFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentSnPtSearch(String surname, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String studSN = "";
        String studPT = "";
        for (Student student : students) {
            studSN = student.getSurname();
            studPT = student.getPatronymic();
            if (studSN.equals(surname) && studPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentFnPtSearch(String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String studFN = "";
        String studPT = "";
        for (Student student : students) {
            studFN = student.getFirstName();
            studPT = student.getPatronymic();
            if (studFN.equals(firstName) && studPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentSnSearch(String surname) {
        List<Student> studentList = new ArrayList<Student>();
        String studSN = "";
        for (Student student : students) {
            studSN = student.getSurname();
            if (studSN.equals(surname)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentFnSearch(String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String studFN = "";
        for (Student student : students) {
            studFN = student.getFirstName();
            if (studFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> studentPtSearch(String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String studPT = "";
        for (Student student : students) {
            studPT = student.getPatronymic();
            if (studPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherSnFnPtSearch(String surname, String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherSN = "";
        String fatherFN = "";
        String fatherPN = "";
        for (Student student : students) {
            fatherSN = student.getFather().getSurname();
            fatherFN = student.getFather().getFirstName();
            fatherPN = student.getFather().getPatronymic();
            if (fatherSN.equals(surname) && fatherFN.equals(firstName) && fatherPN.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherSnFnSearch(String surname, String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherSN = "";
        String fatherFN = "";
        for (Student student : students) {
            fatherSN = student.getFather().getSurname();
            fatherFN = student.getFather().getFirstName();
            if (fatherSN.equals(surname) && fatherFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherSnPtSearch(String surname, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherSN = "";
        String fatherPT = "";
        for (Student student : students) {
            fatherSN = student.getFather().getSurname();
            fatherPT = student.getFather().getPatronymic();
            if (fatherSN.equals(surname) && fatherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherFnPtSearch(String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherFN = "";
        String fatherPT = "";
        for (Student student : students) {
            fatherFN = student.getFather().getFirstName();
            fatherPT = student.getFather().getPatronymic();
            if (fatherFN.equals(firstName) && fatherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherSnSearch(String surname) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherSN = "";
        for (Student student : students) {
            fatherSN = student.getFather().getSurname();
            if (fatherSN.equals(surname)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherFnSearch(String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherFN = "";
        for (Student student : students) {
            fatherFN = student.getFather().getFirstName();
            if (fatherFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherPtSearch(String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String fatherPT = "";
        for (Student student : students) {
            fatherPT = student.getFather().getPatronymic();
            if (fatherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherSnFnPtSearch(String surname, String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String motherSN = "";
        String motherFN = "";
        String motherPN = "";
        for (Student student : students) {
            motherSN = student.getMother().getSurname();
            motherFN = student.getMother().getFirstName();
            motherPN = student.getMother().getPatronymic();
            if (motherSN.equals(surname) && motherFN.equals(firstName) && motherPN.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherSnFnSearch(String surname, String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String motherSN = "";
        String motherFN = "";
        for (Student student : students) {
            motherSN = student.getMother().getSurname();
            motherFN = student.getMother().getFirstName();
            if (motherSN.equals(surname) && motherFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherSnPtSearch(String surname, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String motherSN = "";
        String motherPT = "";
        for (Student student : students) {
            motherSN = student.getMother().getSurname();
            motherPT = student.getMother().getPatronymic();
            if (motherSN.equals(surname) && motherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherFnPtSearch(String firstName, String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String motherFN = "";
        String motherPT = "";
        for (Student student : students) {
            motherFN = student.getMother().getFirstName();
            motherPT = student.getMother().getPatronymic();
            if (motherFN.equals(firstName) && motherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherSnSearch(String surname) {
        List<Student> studentList = new ArrayList<Student>();
        String motherSN = "";
        for (Student student : students) {
            motherSN = student.getMother().getSurname();
            if (motherSN.equals(surname)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherFnSearch(String firstName) {
        List<Student> studentList = new ArrayList<Student>();
        String motherFN = "";
        for (Student student : students) {
            motherFN = student.getMother().getFirstName();
            if (motherFN.equals(firstName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherPtSearch(String patronymic) {
        List<Student> studentList = new ArrayList<Student>();
        String motherPT = "";
        for (Student student : students) {
            motherPT = student.getMother().getPatronymic();
            if (motherPT.equals(patronymic)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherLowUppSalarySearch(double lowerLimit, double upperLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getFather().getSalary() >= lowerLimit && student.getFather().getSalary() <= upperLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherLowSalarySearch(double lowerLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getFather().getSalary() >= lowerLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> fatherUppSalarySearch(double upperLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getFather().getSalary() <= upperLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherLowUppSalarySearch(double lowerLimit, double upperLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getMother().getSalary() >= lowerLimit && student.getFather().getSalary() <= upperLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherLowSalarySearch(double lowerLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getMother().getSalary() >= lowerLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> motherUppSalarySearch(double upperLimit) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getMother().getSalary() <= upperLimit) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> brothersAmountSearch(double brothersAmount) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getBrothersAmount() == brothersAmount) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> sistersAmountSearch(int sistersAmount) {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getSistersAmount() == sistersAmount) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public void studentSnFnPtDelete(String surname, String firstName, String patronymic) {
        String studSN = "";
        String studFN = "";
        String studPN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studSN = student.getSurname();
            studFN = student.getFirstName();
            studPN = student.getPatronymic();
            if (studSN.equals(surname) && studFN.equals(firstName) && studPN.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void studentSnFnDelete(String surname, String firstName) {
        String studSN = "";
        String studFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studSN = student.getSurname();
            studFN = student.getFirstName();
            if (studSN.equals(surname) && studFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void studentSnPtDelete(String surname, String patronymic) {
        String studSN = "";
        String studPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studSN = student.getSurname();
            studPT = student.getPatronymic();
            if (studSN.equals(surname) && studPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void studentFnPtDelete(String firstName, String patronymic) {
        String studFN = "";
        String studPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studFN = student.getFirstName();
            studPT = student.getPatronymic();
            if (studFN.equals(firstName) && studPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void studentSnDelete(String surname) {
        String studSN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studSN = student.getSurname();
            if (studSN.equals(surname)) {
                studentIterator.remove();
            }
        }
    }

    public void studentFnDelete(String firstName) {
        String studFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studFN = student.getFirstName();
            if (studFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void studentPtDelete(String patronymic) {
        String studPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            studPT = student.getPatronymic();
            if (studPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherSnFnPtDelete(String surname, String firstName, String patronymic) {
        String fatherSN = "";
        String fatherFN = "";
        String fatherPN = "";
        Iterator<Student> studentIterator = students.iterator();
        while(studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherSN = father.getSurname();
            fatherFN = father.getFirstName();
            fatherPN = father.getPatronymic();
            if (fatherSN.equals(surname) && fatherFN.equals(firstName) && fatherPN.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherSnFnDelete(String surname, String firstName) {
        String fatherSN = "";
        String fatherFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()){
            Father father = studentIterator.next().getFather();
            fatherSN = father.getSurname();
            fatherFN = father.getFirstName();
            if (fatherSN.equals(surname) && fatherFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherSnPtDelete(String surname, String patronymic) {
        String fatherSN = "";
        String fatherPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherSN = father.getSurname();
            fatherPT = father.getPatronymic();
            if (fatherSN.equals(surname) && fatherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherFnPtDelete(String firstName, String patronymic) {
        String fatherFN = "";
        String fatherPT = "";
        Iterator <Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherFN = father.getFirstName();
            fatherPT = father.getPatronymic();
            if (fatherFN.equals(firstName) && fatherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherSnDelete(String surname) {
        String fatherSN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherSN = father.getSurname();
            if (fatherSN.equals(surname)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherFnDelete(String firstName) {
        String fatherFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherFN = father.getFirstName();
            if (fatherFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherPtDelete(String patronymic) {
        String fatherPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            fatherPT = father.getPatronymic();
            if (fatherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void motherSnFnPtDelete(String surname, String firstName, String patronymic) {
        String motherSN = "";
        String motherFN = "";
        String motherPN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherSN = mother.getSurname();
            motherFN = mother.getFirstName();
            motherPN = mother.getPatronymic();
            if (motherSN.equals(surname) && motherFN.equals(firstName) && motherPN.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void motherSnFnDelete(String surname, String firstName) {
        String motherSN = "";
        String motherFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherSN = mother.getSurname();
            motherFN = mother.getFirstName();
            if (motherSN.equals(surname) && motherFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void motherSnPtDelete(String surname, String patronymic) {
        String motherSN = "";
        String motherPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherSN = mother.getSurname();
            motherPT = mother.getPatronymic();
            if (motherSN.equals(surname) && motherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void motherFnPtDelete(String firstName, String patronymic) {
        String motherFN = "";
        String motherPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherFN = mother.getFirstName();
            motherPT = mother.getPatronymic();
            if (motherFN.equals(firstName) && motherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void motherSnDelete(String surname) {
        String motherSN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherSN = mother.getSurname();
            if (motherSN.equals(surname)) {
                studentIterator.remove();
            }
        }
    }

    public void motherFnDelete(String firstName) {
        String motherFN = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherFN = mother.getFirstName();
            if (motherFN.equals(firstName)) {
                studentIterator.remove();
            }
        }
    }

    public void motherPtDelete(String patronymic) {
        String motherPT = "";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            motherPT = mother.getPatronymic();
            if (motherPT.equals(patronymic)) {
                studentIterator.remove();
            }
        }
    }

    public void fatherLowUppSalaryDelete(double lowerLimit, double upperLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            if (father.getSalary() >= lowerLimit && father.getSalary() <= upperLimit) {
                studentIterator.remove();
            }
        }
    }

    public void fatherLowSalaryDelete(double lowerLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            if (father.getSalary() >= lowerLimit) {
                studentIterator.remove();
            }
        }
    }

    public void fatherUppSalaryDelete(double upperLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Father father = studentIterator.next().getFather();
            if (father.getSalary() <= upperLimit) {
                studentIterator.remove();
            }
        }
    }

    public void motherLowUppSalaryDelete(double lowerLimit, double upperLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            if (mother.getSalary() >= lowerLimit && mother.getSalary() <= upperLimit) {
                studentIterator.remove();
            }
        }
    }

    public void motherLowSalaryDelete(double lowerLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            if (mother.getSalary() >= lowerLimit) {
                studentIterator.remove();
            }
        }
    }

    public void motherUppSalaryDelete(double upperLimit) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Mother mother = studentIterator.next().getMother();
            if (mother.getSalary() <= upperLimit) {
                studentIterator.remove();
            }
        }
    }

    public void brothersAmountDelete(double brothersAmount) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getBrothersAmount() == brothersAmount) {
                studentIterator.remove();
            }
        }
    }

    public void sistersAmountDelete(int sistersAmount) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getSistersAmount() == sistersAmount) {
                studentIterator.remove();
            }
        }
    }

    public List<Student> getPage(int currentPage, int recodesNumber) {
        List<Student> page = new ArrayList<Student>();
        int beginIndex = (currentPage - 1) * (recodesNumber);
        int endIndex = beginIndex + (recodesNumber);
        for (int studentIndex = beginIndex; studentIndex < endIndex; studentIndex++) {
            if (studentIndex >= students.size()) {
                break;
            }
            page.add(students.get(studentIndex));
        }
        return page;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}