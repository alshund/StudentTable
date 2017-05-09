package studentDataBase;

import observe.Observable;
import observe.Observer;
import strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shund on 13.04.2017.
 */
public class StudentDataBase implements Observable {
    private List<Student> students;
    private List<Observer> observerList;
    private SearchStrategy searchStrategy;

    public StudentDataBase() {
        students = new ArrayList<Student>();
        observerList = new LinkedList<Observer>();
    }

    @Override
    public void addTable(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeTable(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void repaintPaging() {
        for (Observer observer : observerList) {
            observer.repaintPaging(students.size());
        }
    }

    @Override
    public void refreshPaging() {
        for (Observer observer : observerList) {
            observer.refreshPaging(students.size());
        }
    }

    @Override
    public void updateData(List<Student> page) {
        for (Observer observer : observerList) {
            observer.updateData(page);
        }
    }

    @Override
    public void createModel() {
        for (Observer observer : observerList) {
            observer.createModel();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        repaintPaging();
    }

    public void changeRecodesAmount() {
        refreshPaging();
    }

    public void changePage(int currentPage, int recodesAmount) {
        updateData(getPage(currentPage, recodesAmount));
    }

    public List <Student> getPage(int currentPage, int recodesNumber) {
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

    public List<Student> search() {
        List<Student> searchList = new ArrayList<Student>();
        for (Student student : students) {
            if (searchStrategy.execute(student)) {
                searchList.add(student);
            }
        }
        return searchList;
    }

    public void delete() {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            if (searchStrategy.execute(studentIterator.next())) {
                studentIterator.remove();
            }
        }
        repaintPaging();
    }

    public int getDataBaseSize() {
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        createModel();
        repaintPaging();
    }

    public SearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(SearchStrategy SearchStrategy) {
        this.searchStrategy = SearchStrategy;
    }
}