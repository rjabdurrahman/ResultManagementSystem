package resultmanagement;

import javafx.collections.ObservableList;

public class LocalAdmin extends Admin{
    
    public LocalAdmin(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    void manageAdmin(String username, String password, ObservableList<LocalAdmin> alist) {
        //here
    }
}