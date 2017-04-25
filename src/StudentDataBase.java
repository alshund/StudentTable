import java.util.ArrayList;
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

    public List<Student> studentSnFnPnSearch(String surname, String firstName, String patronymic) {
        List <Student> studentList = new ArrayList<Student>();
        String currentStudSN = "";
        String currentStudFN = "";
        String currentStudPN = "";
        for (Student student : students) {
            currentStudSN = student.getSurname();
            currentStudFN = student.getFirstName();
            currentStudPN = student.getPatronymic();
            if (currentStudSN.equals(surname) && currentStudFN.equals(firstName) && currentStudPN.equals(patronymic)) {
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
