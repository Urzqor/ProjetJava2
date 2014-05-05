
public class User {

    public boolean connected;
    public boolean isManager;

    public User(){

        this.connected = false;
        this.isManager = false;
    }

    public void connect(){

        this.connected = true;
    }

    public void disconnect(){

        this.connected = false;
    }
}
