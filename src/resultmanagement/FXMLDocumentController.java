package resultmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
    ObservableList<User> userlist = FXCollections.observableArrayList();
    //Admin
    Admin admin = new Admin(111, "1", "1");
    public static ObservableList<Admin> adminlist = FXCollections.observableArrayList();
    //RegisterList
    public static ObservableList<Register> registerlist = FXCollections.observableArrayList();

    @FXML
    private Pane admin_menu, register_menu, teacher_menu, student_menu, consultant_menu, advisor_menu;

    @FXML
    private AnchorPane admin_login_panel, register_login_panel, teacher_login_panel, consultant_login_panel, advisor_login_panel;

    @FXML
    private AnchorPane admin_dashboard, register_dashboard;
    
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
    }
    
    @FXML
    private JFXButton admin_login_btn, register_login_btn;
    
    @FXML
    private JFXTextField admin_username_field,register_username_field;

    @FXML
    private JFXPasswordField admin_password_field,register_password_field;
    
    //Field Cleaner
    public void clear(TextField ... field){
        for(TextField f : field){
            f.clear();
        }
    }
    //Login Button Action
    @FXML
    void loginAct(ActionEvent event) {
        if (event.getSource() == admin_login_btn) {
            userlist.clear();
            userlist.addAll(adminlist);
            if (User.login(admin_username_field.getText(),admin_password_field.getText(),userlist)) {
                admin_login_panel.setVisible(false);
                admin_dashboard.setVisible(true);
                clear(admin_username_field,admin_password_field);
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
            }
        } 
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
        }
    }
    
    @FXML
    private JFXButton admin_login_cancel_btn, admin_login_close_btn, register_login_cancel_btn, register_login_close_btn, teacher_login_cancel_btn, teacher_login_close_btn, consultant_login_cancel_btn, consultant_login_close_btn, advisor_login_cancel_btn, advisor_login_close_btn;

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
        }
        else if (event.getSource() == consultant_login_cancel_btn || event.getSource() == consultant_login_close_btn) {
            consultant_login_panel.setVisible(false);
        }
        else if (event.getSource() == advisor_login_cancel_btn || event.getSource() == advisor_login_close_btn) {
            advisor_login_panel.setVisible(false);
        }

    }
    //Admins Panel
    @FXML
    private JFXButton admin_logout_btn, register_reg_btn;
    
    @FXML
    private JFXTextField register_username_input;

    @FXML
    private JFXPasswordField register_password_input, register_cpassword_input;
    
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
        else if(event.getSource()==register_reg_btn){//Worong Here
            //Check existed username needed
            if(register_password_input.getText().equals(register_cpassword_input.getText())){
                admin.manageRegister(register_username_input.getText(), register_password_input.getText(), registerlist);
                clear(register_username_input, register_password_input, register_cpassword_input);
                //Table Data Load
                register_id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
                register_name_column.setCellValueFactory(new PropertyValueFactory<>("username"));
                register_list_table.setItems(registerlist);
                for(Register r: registerlist)
                    System.out.println(r.getUsername());
            }
            else
                System.out.println("NO");
            //Register Added End
        }
    }
    
    //Registers Panel
    @FXML
    private JFXButton register_logout_btn;
    @FXML
    // -- Register Actions
    void registerAct(ActionEvent event) {
        if(event.getSource() == register_logout_btn){
            register_dashboard.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adminlist.add(admin);
    }

}
