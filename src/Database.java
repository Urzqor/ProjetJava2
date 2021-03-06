import java.sql.*;

public class Database {

    public String url;
    public String dbname;
    public String user;
    public String psw;

    public String driver = "com.mysql.jdbc.Driver";
    public Connection conn = null;

    public Statement st;
    public ResultSet result;

    public Database(String url, String dbname, String user, String psw){

        this.url = url;
        this.dbname = dbname;
        this.user = user;
        this.psw = psw;
    }

    // GETTING THE CONNECTION
    public void instanciate(){

        try{

            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.url+this.dbname, this.user, this.psw);
            this.st = this.conn.createStatement();

        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

}
