import java.util.Objects;

/**
 * Created by shund on 09.04.2017.
 */
public class Student {
    private String firstName;
    private String middleName;
    private String surname;
    private Mother mother;
    private Father father;
    private int numberOfBrothers;
    private int numberOfSisters;

    public Student() {

    }

    public Object getField(int columnIndex) {
        if (columnIndex == 0) {
            String studentFullName = surname + " " + firstName + " " + middleName;
            return studentFullName;
        } else if (columnIndex == 1) {
            String fatherFullName = father.getSurname() + " " + father.getFirstName() + " " + father.getMiddleName();
            return fatherFullName;
        } else if (columnIndex == 2) {
            return father.getSalary();
        } else if (columnIndex == 3) {
            String motherFullName = mother.getSurname() + " " + mother.getFirstName() + " " + mother.getMiddleName();
            return motherFullName;
        } else if (columnIndex == 4) {
            return mother.getSalary();
        } else if (columnIndex == 5) {
            return numberOfBrothers;
        } else if (columnIndex == 6) {
            return numberOfSisters;
        } else {
            return null;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public double getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public void setNumberOfBrothers(int numberOfBrothers) {
        this.numberOfBrothers = numberOfBrothers;
    }

    public double getNumberOfSisters() {
        return numberOfSisters;
    }

    public void setNumberOfSisters(int numberOfSisters) {
        this.numberOfSisters = numberOfSisters;
    }
}
