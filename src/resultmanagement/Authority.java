package resultmanagement;

import javafx.collections.ObservableList;

public abstract class Authority extends User{
    
    public Authority(int id, String username, String password) {
        super(id, username, password);
    }
    //Abstract Method
    public abstract void manageRegister(String username,String password,ObservableList<Register> rlist);
    
}
