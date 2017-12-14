package resultmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Teacher extends User implements IResultActivity{
    public ObservableList<Course> courseList = FXCollections.observableArrayList();
    
    public Teacher(int id, String username, String password) {
        super(id, username, password);
    }
    
    public void addResult(int sid, int code, double gpa){
        for(Student s : FXMLDocumentController.student_list){
            if(s.getId()==sid){
                for(Course c : s.courseList){
                    if(c.getCode()==code){
                        c.setGpa(gpa);
                        break;
                    }
                }
            }
        }
    }
    public void reportStudent(){
        //here
    }

    @Override
    public void viewResult() {
        double totalgpa = 0;
        int count = 0;
        for(Student s : FXMLDocumentController.student_list){
            for(Course c : s.courseList){
                totalgpa += c.getGpa();
                count++;
            }
            s.cgpa = totalgpa/count;
            totalgpa = 0;
            count = 0;
            System.out.println("Student: " + s.getId());
            System.out.println("Student: " + s.cgpa);
        }
    }
}