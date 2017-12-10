package resultmanagement;

import java.util.ArrayList;

public class Student extends User{
    public ArrayList<Course> courseList = new ArrayList<>();
    public ArrayList<String> teacherRecommends = new ArrayList<>();
    public String advisorMark;
    
    public Student(int id, String username, String password) {
        super(id, username, password);
    }
    
}