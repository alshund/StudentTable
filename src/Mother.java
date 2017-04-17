/**
 * Created by shund on 09.04.2017.
 */
public class Mother {
    private String firstName;
    private String middleName;
    private String surname;
    private double salary;

    public Mother(String firstName, String middleName, String surname, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
