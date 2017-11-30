package resultmanagement;

import java.util.ArrayList;

public class Student{
    private int id;
    private String name;
    ArrayList<Course> clist;

    public Student(int id, String name, ArrayList<Course> clist) {
        this.id = id;
        this.name = name;
        this.clist = new ArrayList<>();
    }
    public void searchResulst(){
        //here
    }
    
}