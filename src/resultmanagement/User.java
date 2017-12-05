package resultmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
}