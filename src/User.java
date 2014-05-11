import java.sql.*;

public class User {

    public boolean connected;
    public boolean isManager;
    public String name = "";
    public Database db;

    public User(Database db){

        this.connected = false;
        this.isManager = false;
        this.db = db;
    }

    public boolean connect(){

        this.connected = true;
        return true;
    }

    public void disconnect(){

        try{
            this.db.conn.close();
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        this.connected = false;
    }

    // CREATING A NEW USER
    public boolean register(String username, String psw){

        int count = 0;
        String type = (this.isManager == true) ? "manager" : "normal";
        String rqst = "SELECT id FROM users WHERE name='"+username+"';";

        try {

            this.db.result = this.db.st.executeQuery(rqst);
            while( this.db.result.next()){
                count ++;
            }
            if (count >= 1){
                // User already exists
                return false;
            }

            rqst = "INSERT INTO users (name, psw, type) " +
                    "VALUES ('"+username+"', '"+psw+"', '"+type+"');";

            this.db.st.executeUpdate(rqst);

        }catch(Exception e){

            System.out.println(e.toString());
            e.printStackTrace();
        }

        return true;
    }


    // LOG IN AN USER
    public boolean login(String username, String psw){

        int count=0;
        String rqst = "SELECT id FROM users WHERE name='"+username+"' AND psw='"+psw+"';";

        try {

            this.db.result = this.db.st.executeQuery(rqst);
            while( this.db.result.next()){
                count ++;
            }
            if (count >= 1){
                // User exists
                this.name = username;
                return true;
            }
        }catch(Exception e){

            System.out.println(e.toString());
            e.printStackTrace();
        }

        return false;
    }
}
