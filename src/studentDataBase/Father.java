package studentDataBase;

/**
 * Created by shund on 09.04.2017.
 */
public class Father {
    private String firstName;
    private String patronymic;
    private String surname;
    private double salary;

    public Father(String surname, String firstName, String patronymic, double salary) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
    }

    public Father () {

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
