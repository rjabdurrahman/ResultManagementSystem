package resultmanagement;

import javafx.collections.ObservableList;

public abstract class Admin extends Authority{

    public Admin(int id, String username, String password) {
        super(id, username, password);
    }
    
    //abstract methodp
    abstract void manageAdmin(String username, String password, ObservableList<LocalAdmin> alist);
    
    public void publishResult(){
        //here
    }
    
}