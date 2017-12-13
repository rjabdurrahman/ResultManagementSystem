package resultmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    //Temperory User List
    ObservableList<User> userlist = FXCollections.observableArrayList();
    //Global Admin
    GlobalAdmin admin = new GlobalAdmin(111, "1", "1");
    public static ObservableList<GlobalAdmin> global_adminlist = FXCollections.observableArrayList();
    //Local Admin List
    public static ObservableList<LocalAdmin> local_adminlist = FXCollections.observableArrayList();
    //Register List
    public static ObservableList<Register> registerlist = FXCollections.observableArrayList();
    //Course List
    public static ObservableList<Course> course_list = FXCollections.observableArrayList();
    //Student List
    public static ObservableList<Student> student_list = FXCollections.observableArrayList();
    Student logged_student = null;
    //Teacher List
    public static ObservableList<Teacher> teacher_list = FXCollections.observableArrayList();
    //Advisor List
    public static ObservableList<Advisor> advisor_list = FXCollections.observableArrayList();

    @FXML
    private Pane admin_menu, register_menu, teacher_menu, student_menu, consultant_menu, advisor_menu;

    @FXML
    private AnchorPane admin_login_panel, register_login_panel, teacher_login_panel, consultant_login_panel, advisor_login_panel,student_login_panel;

    @FXML
    private AnchorPane admin_dashboard,localAdmin_dashboard, register_dashboard, teacher_dashboard,student_dashboard;
    
    @FXML
    private ToggleGroup admin_rype_toggle, register_rype_toggle;

    //Main Menu Action
    @FXML
    void mainAct(MouseEvent event) {
        if (event.getSource() == admin_menu) {
            admin_login_panel.setVisible(true);
        } 
        else if (event.getSource() == register_menu) {
            register_login_panel.setVisible(true);
        }
        else if (event.getSource() == teacher_menu) {
            teacher_login_panel.setVisible(true);
        }
        else if (event.getSource() == consultant_menu) {
            consultant_login_panel.setVisible(true);
        }
        else if (event.getSource() == advisor_menu) {
            advisor_login_panel.setVisible(true);
        }
        else if (event.getSource() == student_menu) {
            student_login_panel.setVisible(true);
        }
    }
    //Login Panels Fields
    @FXML
    private JFXRadioButton admin_global_radio, admin_local_radio;
    
    @FXML
    private JFXButton admin_login_btn, register_login_btn, teacher_login_btn, student_login_btn;
    
    @FXML
    private JFXTextField admin_username_field,register_username_field,teacher_username_field,student_username_field;

    @FXML
    private JFXPasswordField admin_password_field,register_password_field,teacher_password_field,student_password_field;
    
    //Field Cleaner
    public void clear(TextField ... field){
        for(TextField f : field){
            f.clear();
        }
    }
    //Login Button Action
    @FXML
    void loginAct(ActionEvent event) {
        if (event.getSource() == admin_login_btn && !admin_global_radio.isSelected() && !admin_local_radio.isSelected()) {
            JOptionPane.showMessageDialog(null,"Please Select Admin Type!");
        }
        else if (event.getSource() == admin_login_btn && admin_global_radio.isSelected()) {
            userlist.clear();
            userlist.addAll(global_adminlist);
            if (User.login(admin_username_field.getText(),admin_password_field.getText(),userlist)) {
                admin_login_panel.setVisible(false);
                admin_dashboard.setVisible(true);
                clear(admin_username_field,admin_password_field);
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
            }
        } //Global Admin Login End
        else if (event.getSource() == admin_login_btn && admin_local_radio.isSelected()) {
            userlist.clear();
            userlist.addAll(local_adminlist);
            if (User.login(admin_username_field.getText(),admin_password_field.getText(),userlist)) {
                admin_login_panel.setVisible(false);
                localAdmin_dashboard.setVisible(true);
                //Load Table Data
                register_id_column2.setCellValueFactory(new PropertyValueFactory<>("id"));
                register_name_column2.setCellValueFactory(new PropertyValueFactory<>("username"));
                register_list_table2.setItems(registerlist);
                clear(admin_username_field,admin_password_field);
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
            }
        }//Local Admin Login end
        else if (event.getSource() == register_login_btn) {
            userlist.clear();
            userlist.addAll(registerlist);
            if (User.login(register_username_field.getText(),register_password_field.getText(),userlist)) {
                register_login_panel.setVisible(false);
                register_dashboard.setVisible(true);
                clear(register_username_field,register_password_field);
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
            }
        }//Register Login End
        else if (event.getSource() == teacher_login_btn) {
            userlist.clear();
            userlist.addAll(teacher_list);
            if (User.login(teacher_username_field.getText(),teacher_password_field.getText(),userlist)) {
                teacher_login_panel.setVisible(false);
                teacher_dashboard.setVisible(true);
                teacher_courseCode_list.clear();
                teacher_list.forEach(t->{
                    if(t.getUsername().equals(teacher_username_field.getText())){
                        t.courseList.forEach(c->{
                            teacher_courseCode_list.add(Integer.toString(c.getCode()));
                        });
                    }
                });
                clear(teacher_username_field,teacher_password_field);
                teacherCourse_combo.setItems(teacher_courseCode_list);
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
            }
        }//Teacher Login End
        else if (event.getSource() == student_login_btn) {
            boolean logged = false;
            for(Student s : student_list){
                if(s.getId()==Integer.parseInt(student_username_field.getText()) && s.getPassword().equals(student_password_field.getText())){
                    logged_student = s;
                    clear(student_username_field,student_password_field);
                    logged = true;
                    student_dashboard.setVisible(true);
                    break;
                }
            }
            if(!logged)
                JOptionPane.showMessageDialog(null,"Wrong StudentID or Password!");
        }//Student Login End
    }
    
    @FXML
    private JFXButton admin_login_cancel_btn, admin_login_close_btn, register_login_cancel_btn, register_login_close_btn, teacher_login_cancel_btn, teacher_login_close_btn, consultant_login_cancel_btn, consultant_login_close_btn, advisor_login_cancel_btn, advisor_login_close_btn,student_login_cancel_btn,student_login_close_btn;

    //Cancel Button Action
    @FXML
    void login_cancel_act(ActionEvent event) {
        if (event.getSource() == admin_login_cancel_btn || event.getSource() == admin_login_close_btn) {
            admin_login_panel.setVisible(false);
            clear(admin_username_field,admin_password_field);
        } 
        else if (event.getSource() == register_login_cancel_btn || event.getSource() == register_login_close_btn) {
            register_login_panel.setVisible(false);
            clear(register_username_field,register_password_field);
        }
        else if (event.getSource() == teacher_login_cancel_btn || event.getSource() == teacher_login_close_btn) {
            teacher_login_panel.setVisible(false);
            clear(teacher_username_field,teacher_password_field);
        }
        else if (event.getSource() == consultant_login_cancel_btn || event.getSource() == consultant_login_close_btn) {
            consultant_login_panel.setVisible(false);
        }
        else if (event.getSource() == advisor_login_cancel_btn || event.getSource() == advisor_login_close_btn) {
            advisor_login_panel.setVisible(false);
        }
        else if (event.getSource() == student_login_cancel_btn || event.getSource() == student_login_close_btn) {
            student_login_panel.setVisible(false);
            clear(student_username_field,student_password_field);
        }

    }
    //Admins Panel
    @FXML
    private AnchorPane admin_manageAdmin_panel, admin_manageRegister_panel;
    
    @FXML
    private JFXButton admin_manageAdmin_btn,admin_manageRegister_btn,admin_register_add_btn,admin_register_remove_btn,admin_logout_btn,admin_localAdmin_add_btn,admin_localAdmin_remove_btn;
    
    @FXML
    private JFXTextField register_username_input,register_username_input_remove,localAdmin_username_input,localAdmin_username_input_remove;

    @FXML
    private JFXPasswordField register_password_input, register_cpassword_input,localAdmin_password_input,localAdmin_cpassword_input;
    
    // -- Register List Table
    @FXML
    private TableView<Register> register_list_table;

    @FXML
    private TableColumn<Register, Integer> register_id_column;

    @FXML
    private TableColumn<Register, String> register_name_column;
    // -- Amin Actions
    @FXML
    void adminAct(ActionEvent event) {
        if(event.getSource() == admin_logout_btn){
            admin_dashboard.setVisible(false);
        }
        else if(event.getSource() == admin_manageAdmin_btn){
            admin_manageAdmin_panel.toFront();
        }
        else if(event.getSource() == admin_manageRegister_btn){
            register_id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
            register_name_column.setCellValueFactory(new PropertyValueFactory<>("username"));
            register_list_table.setItems(registerlist);
            admin_manageRegister_panel.setVisible(true);
            admin_manageRegister_panel.toFront();
        }
        //Add and Remove Register Start
        else if(event.getSource()==admin_register_add_btn){
            //Check existed username needed
            if(register_password_input.getText().equals(register_cpassword_input.getText())){
                for(Register r: registerlist){
                    if(r.getUsername().equals(register_username_input.getText())){
                        JOptionPane.showMessageDialog(null, "Username Already Existed!");
                        return;
                    }
                } //Check Repeating Username End
                admin.manageRegister(register_username_input.getText(), register_password_input.getText(), registerlist);
                clear(register_username_input, register_password_input, register_cpassword_input);
                //Table Data Load
                register_list_table.setItems(registerlist);
            }
            else
                JOptionPane.showMessageDialog(null, "Password Not Matched!");
            //Register Added End
        }
        else if(event.getSource()==admin_register_remove_btn){
            admin.manageRegister(register_username_input_remove.getText(), registerlist);
            clear(register_username_input_remove);
            register_list_table.setItems(registerlist);
        }
        //Golbal Admins Local Admin
        else if(event.getSource()==admin_localAdmin_add_btn){
            if(localAdmin_password_input.getText().equals(localAdmin_cpassword_input.getText())){
                for(LocalAdmin r: local_adminlist){
                    if(r.getUsername().equals(localAdmin_username_input.getText())){
                        JOptionPane.showMessageDialog(null, "Username Already Existed!");
                        return;
                    }
                } //Check Repeating Username End
                admin.manageAdmin(localAdmin_username_input.getText(), localAdmin_password_input.getText(), local_adminlist);
                clear(localAdmin_username_input, localAdmin_password_input, localAdmin_cpassword_input);
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
            }
            else
                JOptionPane.showMessageDialog(null, "Password Not Matched!");
        }
        else if(event.getSource()==admin_localAdmin_remove_btn){
            admin.manageAdmin(localAdmin_username_input_remove.getText(), local_adminlist);
            clear(localAdmin_username_input_remove);
            JOptionPane.showMessageDialog(null, "Admin Removed Successfully!");
        }
        
    }
    //Local Admin Panel
    @FXML
    AnchorPane localAdmin_manageRegister_panel,localAdmin_myMenu_panel;
    
    @FXML
    JFXButton localAdmin_logout_btn,localAdmin_manageRegister_btn,localAdmin_myMenu_btn,admin_register_add_btn2,admin_register_remove_btn2;
    
    @FXML
    private JFXTextField register_username_input2,register_username_input_remove2,localAdmin_username_input2,localAdmin_username_input_remove2;

    @FXML
    private JFXPasswordField register_password_input2, register_cpassword_input2,localAdmin_password_input2,localAdmin_cpassword_input2;
    // -- Register List Table
    @FXML
    private TableView<Register> register_list_table2;

    @FXML
    private TableColumn<Register, Integer> register_id_column2;

    @FXML
    private TableColumn<Register, String> register_name_column2;
    // -- Local Admin Actions
    @FXML
    void localAdminAct(ActionEvent event) {
        if(event.getSource() == localAdmin_logout_btn){
            localAdmin_dashboard.setVisible(false);
        }
        else if(event.getSource() == localAdmin_manageRegister_btn){
            localAdmin_manageRegister_panel.setVisible(true);
            localAdmin_manageRegister_panel.toFront();
        }
        else if(event.getSource() == localAdmin_myMenu_btn){
            localAdmin_myMenu_panel.setVisible(true);
            localAdmin_myMenu_panel.toFront();
        }
        else if(event.getSource()==admin_register_add_btn2){
            //Check existed username needed
            if(register_password_input2.getText().equals(register_cpassword_input2.getText())){
                for(Register r: registerlist){
                    if(r.getUsername().equals(register_username_input2.getText())){
                        JOptionPane.showMessageDialog(null, "Username Already Existed!");
                        return;
                    }
                } //Check Repeating Username End
                admin.manageRegister(register_username_input2.getText(), register_password_input2.getText(), registerlist);
                clear(register_username_input2, register_password_input2, register_cpassword_input2);
                //Table Data Load
                register_id_column2.setCellValueFactory(new PropertyValueFactory<>("id"));
                register_name_column2.setCellValueFactory(new PropertyValueFactory<>("username"));
                register_list_table2.setItems(registerlist);
            }
            else
                JOptionPane.showMessageDialog(null, "Password Not Matched!");
            //Register Added End
        }
        else if(event.getSource()==admin_register_remove_btn2){
            admin.manageRegister(register_username_input_remove2.getText(), registerlist);
            clear(register_username_input_remove2);
            register_id_column2.setCellValueFactory(new PropertyValueFactory<>("id"));
            register_name_column2.setCellValueFactory(new PropertyValueFactory<>("username"));
            register_list_table2.setItems(registerlist);
        }
    }
    
    //Registers Panel
    Register register = new Register(124, "reg", "123");
    @FXML
    private JFXButton register_logout_btn,course_add_btn,student_add_btn,teacher_add_btn,reg_course_btn;
    @FXML
    private JFXTextField course_code_input,course_name_input,course_credit_input,student_id_input,student_name_input,student_password_input,teacher_id_input,teacher_name_input,teacher_password_input,registerFor_id;
    @FXML
    private JFXRadioButton regForTeacher,regForStudent;
    @FXML
    private JFXComboBox<String> regCourse_combo;
    public ObservableList<String> course_code_list = FXCollections.observableArrayList();
    // -- Register Actions
    @FXML
    void registerAct(ActionEvent event) {
        if(event.getSource() == register_logout_btn){
            register_dashboard.setVisible(false);
        }
        else if(event.getSource() == course_add_btn){
            register.addCourses(Integer.parseInt(course_code_input.getText()), course_name_input.getText(), Integer.parseInt(course_credit_input.getText()));
            course_code_list.add(course_code_input.getText());
            regCourse_combo.setItems(course_code_list);
            clear(course_code_input,course_name_input,course_credit_input);
            JOptionPane.showMessageDialog(null, "Course Added Successfully!");
        }
        else if(event.getSource() == student_add_btn){
            register.addStudent(Integer.parseInt(student_id_input.getText()), student_name_input.getText(), student_password_input.getText());
            clear(student_id_input,student_name_input,student_password_input);
            JOptionPane.showMessageDialog(null, "Student Added Successfully!");
        }
        else if(event.getSource() == teacher_add_btn){
            register.addTeacher(Integer.parseInt(teacher_id_input.getText()), teacher_name_input.getText(), teacher_password_input.getText());
            clear(teacher_id_input,teacher_name_input,teacher_password_input);
            JOptionPane.showMessageDialog(null, "Teacher Added Successfully!");
        }
        else if(event.getSource() == reg_course_btn && !regForTeacher.isSelected() && !regForStudent.isSelected()){
            JOptionPane.showMessageDialog(null,"Please Select Type!");
        }
        else if(event.getSource() == reg_course_btn && regForStudent.isSelected()){
            //Warning Needed!
            register.regStudentCourses(Integer.parseInt(registerFor_id.getText()), Integer.parseInt(regCourse_combo.getValue()));
            clear(registerFor_id);
            JOptionPane.showMessageDialog(null, "Student's Course Added Successfully!");
        }
        else if(event.getSource() == reg_course_btn && regForTeacher.isSelected()){
            //Warning Needed!
            register.regTeacherCourses(Integer.parseInt(registerFor_id.getText()), Integer.parseInt(regCourse_combo.getValue()));
            clear(registerFor_id);
            JOptionPane.showMessageDialog(null, "Teacher's Course Added Successfully!");
        }
    }
    //Teachers Panel
    Teacher teacher = new Teacher(818, "teacher", "232");
    @FXML
    private JFXButton teacher_logout_btn,teacher_markAdd_btn;
    @FXML
    private JFXTextField techer_studentId_input,teacher_mark_input;
    @FXML
    private JFXComboBox<String> teacherCourse_combo;
    public ObservableList<String> teacher_courseCode_list = FXCollections.observableArrayList();
    // -- Teachers Actions
    @FXML
    void teacherAct(ActionEvent event) {
        if(event.getSource() == teacher_logout_btn){
            teacher_dashboard.setVisible(false);
        }
        else if(event.getSource() == teacher_markAdd_btn){
            teacher.addResult(Integer.parseInt(techer_studentId_input.getText()), Integer.parseInt(teacherCourse_combo.getValue()), Double.parseDouble(teacher_mark_input.getText()));
            clear(techer_studentId_input,teacher_mark_input);
            JOptionPane.showMessageDialog(null, "GPA Added Successfully!");
            student_list.forEach(s->{
                System.out.println(s.getId());
                s.courseList.forEach(c->{
                    System.out.println(c.getGpa());
                });
            });
        }
    }
    // -- Students Actions
    @FXML
    private JFXButton student_logout_btn,student_viewResult_btn;
    
    @FXML
    private TableView<Course> student_result_table;

    @FXML
    private TableColumn<Course, Integer> st_table_course_code;

    @FXML
    private TableColumn<Course, String> st_table_course_name;
    
    @FXML
    private TableColumn<Course, String> st_table_course_gpa;
    
    @FXML
    void studentAct(ActionEvent event) {
        if(event.getSource() == student_logout_btn){
            student_dashboard.setVisible(false);
            logged_student = null;
        }
        else if(event.getSource() == student_viewResult_btn){
            st_table_course_code.setCellValueFactory(new PropertyValueFactory<>("code"));
            st_table_course_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            st_table_course_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
            student_result_table.setItems(logged_student.courseList);
            System.out.println(logged_student.getUsername());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        global_adminlist.add(admin);
    }

}
