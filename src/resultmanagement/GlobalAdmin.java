package resultmanagement;

import javafx.collections.ObservableList;

public class GlobalAdmin extends Admin{

    public GlobalAdmin(int id, String username, String password) {
        super(id, username, password);
    }
    
    @Override
    public void manageAdmin(){
        //here
    }
    //Overloaded Overridden ManageAdmin
    public void manageAdmin(String username,String password,ObservableList<LocalAdmin> alist){
        alist.add(new LocalAdmin(124, username, password));
    }
}