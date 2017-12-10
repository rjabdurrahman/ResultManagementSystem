package resultmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Teacher extends User{
    public ObservableList<Course> courseList = FXCollections.observableArrayList();
    
    public Teacher(int id, String username, String password) {
        super(id, username, password);
    }
    
    public void addResult(int sid,int code,double gpa){
        //here
    }
    public void reportStudent(){
        //here
    }
}