package resultmanagement;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student extends User implements IResultActivity{
    public ObservableList<Course> courseList = FXCollections.observableArrayList();
    public double cgpa;
    public ArrayList<String> teacherRecommends = new ArrayList<>();
    public String advisorMark;
    
    public Student(int id, String username, String password) {
        super(id, username, password);
    }
    //Constructor Overloading
    public Student(int id, String password) {
        super(id, "Unknown", password);
    }

    @Override
    public void viewResult() {
        for(Course c : courseList){
            System.out.println("Course Code: " + c.getCode());
            System.out.println("GPA: " + c.getGpa());
        }
    }

    public double getCgpa() {
        return cgpa;
    }
    
    
    
}