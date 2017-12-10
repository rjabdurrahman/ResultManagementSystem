package resultmanagement;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student extends User{
    public ObservableList<Course> courseList = FXCollections.observableArrayList();;
    public ArrayList<String> teacherRecommends = new ArrayList<>();
    public String advisorMark;
    
    public Student(int id, String username, String password) {
        super(id, username, password);
    }
    
}