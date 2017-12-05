package resultmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class User{
    private SimpleIntegerProperty id;
    private SimpleStringProperty username;
    private String password;

    public User(int id, String username, String password) {
        this.id = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.password = password;
    }

    public Integer getId() {
        return id.get();
    }
    
    public String getUsername() {
        return username.get();
    }
    
    public String getPassword() {
        return password;
    }
    
    //Login
    public static boolean login(String username, String password, ObservableList<User> ulist) {
        for(User user : ulist){
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}