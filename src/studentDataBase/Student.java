package studentDataBase;

import constants.Table;

/**
 * Created by shund on 09.04.2017.
 */
public class Student {
    private String firstName;
    private String patronymic;
    private String surname;
    private Mother mother;
    private Father father;
    private int brothersAmount;
    private int sistersAmount;

    public Student() {
        father = new Father();
        mother = new Mother();
    }

    public Object getField(int columnIndex) {
        if (columnIndex == Table.STUDENT_NAME_COLUMN) {
            String studentFullName = surname + " " + firstName + " " + patronymic;
            return studentFullName;
        } else if (columnIndex == Table.FATHER_NAME_COLUMN) {
            String fatherFullName = father.getSurname() + " " + father.getFirstName() + " " + father.getPatronymic();
            return fatherFullName;
        } else if (columnIndex == Table.FATHER_SALARY_COLUMN) {
            return father.getSalary();
        } else if (columnIndex == Table.MOTHER_NAME_COLUMN) {
            String motherFullName = mother.getSurname() + " " + mother.getFirstName() + " " + mother.getPatronymic();
            return motherFullName;
        } else if (columnIndex == Table.MOTHER_SALARY_COLUMN) {
            return mother.getSalary();
        } else if (columnIndex == Table.BROTHER_AMOUNT_COLUMN) {
            return brothersAmount;
        } else if (columnIndex == Table.SISTER_AMOUNT_COLUMN) {
            return sistersAmount;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public int getBrothersAmount() {
        return brothersAmount;
    }

    public void setBrothersAmount(int numberOfBrothers) {
        this.brothersAmount = numberOfBrothers;
    }

    public int getSistersAmount() {
        return sistersAmount;
    }

    public void setSistersAmount(int numberOfSisters) {
        this.sistersAmount = numberOfSisters;
    }
}
