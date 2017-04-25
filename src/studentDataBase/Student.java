package studentDataBase;

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
    private int sistersAMount;

    public Student() {
        father = new Father();
        mother = new Mother();
    }

    public Object getField(int columnIndex) {
        if (columnIndex == 0) {
            String studentFullName = surname + " " + firstName + " " + patronymic;
            return studentFullName;
        } else if (columnIndex == 1) {
            String fatherFullName = father.getSurname() + " " + father.getFirstName() + " " + father.getPatronymic();
            return fatherFullName;
        } else if (columnIndex == 2) {
            return father.getSalary();
        } else if (columnIndex == 3) {
            String motherFullName = mother.getSurname() + " " + mother.getFirstName() + " " + mother.getPatronymic();
            return motherFullName;
        } else if (columnIndex == 4) {
            return mother.getSalary();
        } else if (columnIndex == 5) {
            return brothersAmount;
        } else if (columnIndex == 6) {
            return sistersAMount;
        } else {
            return null;
        }
    }

    public void setField (int columnIndex, Object aValue) {
        if (columnIndex == 0) {
            setSurname((String) aValue);
            setFirstName((String) aValue);
            setPatronymic((String) aValue);
        } else if (columnIndex == 1) {
            father.setSurname((String) aValue);
            father.setFirstName((String) aValue);
            father.setPatronymic((String) aValue);
        } else if (columnIndex == 2) {
            father.setSalary((Double) aValue);
        } else if (columnIndex == 3) {
            mother.setSurname((String) aValue);
            mother.setFirstName((String) aValue);
            mother.setPatronymic((String) aValue);
        } else if (columnIndex == 4) {
            mother.setSalary((Double) aValue);
        } else if (columnIndex == 5) {
            setBrothersAmount((Integer) aValue);
        } else if (columnIndex == 6) {
            setBrothersAmount((Integer) aValue);
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
        return sistersAMount;
    }

    public void setSistersAmount(int numberOfSisters) {
        this.sistersAMount = numberOfSisters;
    }
}
