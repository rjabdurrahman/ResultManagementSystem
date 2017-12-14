package resultmanagement;

import javafx.collections.ObservableList;

public class Register extends Authority{
    public boolean status;
    public Register(int id, String username, String password) {
        super(id, username, password);
        status = true;
    }
    //Override Authority Abstract Method
    public void manageRegister(String username,String password,ObservableList<Register> rlist){
        for(Register r : rlist){
            if(r.getUsername().equals(username) && r.getPassword().equals(password)){
                r.status = false;
                break;
            }
        }
    }
    
    public void addCourses(int id, String name, int credit){
        FXMLDocumentController.course_list.add(new Course(id, name, credit));
    }
    public void addStudent(int id, String name, String password){
        FXMLDocumentController.student_list.add(new Student(id, name, password));
    }
    public void addTeacher(int id, String username, String password){
        FXMLDocumentController.teacher_list.add(new Teacher(id, username, password));
    }
    public void regStudentCourses(int sid, int cid){
        for(Student s : FXMLDocumentController.student_list){
            if(s.getId() == sid){
                for(Course c : FXMLDocumentController.course_list){
                    if(c.getCode()==cid){
                        s.courseList.add(new Course(c.getCode(), c.getName(), c.getCredit()));
                        break;
                    }
                }
            }
        }
    }
    public void regTeacherCourses(int tid, int cid){
        for(Teacher t : FXMLDocumentController.teacher_list){
            if(t.getId() == tid){
                for(Course c : FXMLDocumentController.course_list){
                    if(c.getCode()==cid){
                        t.courseList.add(new Course(c.getCode(), c.getName(), c.getCredit()));
                        break;
                    }
                }
            }
        }
    }
    
}