import studentDataBase.StudentDataBase;
import studentTable.MainWindow;
import tableController.TableController;

/**
 * Created by shund on 09.05.2017.
 */
public class TableEditor {
    public static void main(String[] arg) {
        StudentDataBase studentDataBase = new StudentDataBase();
        TableController tableController = new TableController(studentDataBase);
        new MainWindow(tableController);
//        java.util.List<Integer> y = new ArrayList<>(Arrays.asList(2,6,8,-3,7,9));
//        java.util.List<Integer> z = y.stream().filter(element -> element < 5).collect(Collectors.toList());
//        System.out.println(z);
//        z = z.stream().map(e -> e + 1).collect(Collectors.toList());
//        System.out.println(z);
    }
}
