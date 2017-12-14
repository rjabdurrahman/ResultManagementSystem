package resultmanagement;

import javafx.collections.ObservableList;

public class LocalAdmin extends Admin{
    
    public LocalAdmin(int id, String username, String password) {
        super(id, username, password);
    }
    
    //Override Authority Abstract Mehod
    @Override
    public void manageRegister(String username,String password,ObservableList<Register> rlist){
        rlist.add(new Register(121,username,password));
    }
    
    @Override
    void manageAdmin(String username, String password, ObservableList<LocalAdmin> alist) {
        //here
    }
}