package resultmanagement;

import javafx.collections.ObservableList;

public abstract class Admin extends User{

    public Admin(int id, String username, String password) {
        super(id, username, password);
    }
    
    public void manageRegister(String username,String password,ObservableList<Register> rlist){
        rlist.add(new Register(121,username,password));
    }
    public void manageRegister(){
        //here
    }
    public void margeResult(){
        //here
    }
    public void publishResult(){
        //here
    }
    
}