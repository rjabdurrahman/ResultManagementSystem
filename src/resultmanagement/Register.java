package resultmanagement;

public class Register extends User{

    public Register(int id, String username, String password) {
        super(id, username, password);
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
    public void regStudentCourses(){
        //here
    }
    public void regTeacherCourses(){
        //here
    }
    
}