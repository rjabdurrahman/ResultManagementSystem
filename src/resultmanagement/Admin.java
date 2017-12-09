package resultmanagement;

import javafx.collections.ObservableList;

public abstract class Admin extends User{

    public Admin(int id, String username, String password) {
        super(id, username, password);
    }
    
    public void manageRegister(String username,String password,ObservableList<Register> rlist){
        rlist.add(new Register(121,username,password));
    }
    //OverLoad manageRegister
    public void manageRegister(String username,ObservableList<Register> rlist){
        for(Register r : rlist){
            if(r.getUsername().equals(username)){
                rlist.remove(r);
                break;
            }
        }
        //Register Remove end.
    }
    //abstract methodp
    abstract void manageAdmin();
    
    public void margeResult(){
        //here
    }
    public void publishResult(){
        //here
    }
    
}