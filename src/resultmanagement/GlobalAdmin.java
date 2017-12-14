package resultmanagement;

import javafx.collections.ObservableList;

public class GlobalAdmin extends Admin{

    public GlobalAdmin(int id, String username, String password) {
        super(id, username, password);
    }
    //Override Authority Abstract Method
    @Override
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
    
    @Override
    public void manageAdmin(String username,String password,ObservableList<LocalAdmin> alist){
        alist.add(new LocalAdmin(124, username, password));
    }
    
    //Overloaded Overridden ManageAdmin
    public void manageAdmin(String username, ObservableList<LocalAdmin> alist){
        for(LocalAdmin a : alist){
            if(a.getUsername().equals(username)){
                alist.remove(a);
                break;
            }
        }
        //Local Admin Remove end.
    }
    
}