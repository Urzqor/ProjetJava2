/**
 * Projet JAVA B2 : SupPlanner
 */
public class Start {
    public static void main(String args[]){

        /*
        Tasks : - REGISTER, LOGIN, LOGOUT >> DB
                - SUMUP (Dashboard)
                - 2 USERS TYPES (managers, employees)

        MANAGERS :
                - Create a project & modify it
                - Invite others to the project
        EMPLOYEES :
                - Create a task & modify it
                - Mark a task as completed
         */

        // Loading landing screen
        Layout mainWindow = new Layout(400,600,"SupPlanner");
        mainWindow.init();
        mainWindow.window.createMainWindow(mainWindow);

        // Creating an empty user
        User user = new User();

        // Connection to the database
        Database db = new Database(
            "jdbc:mysql://127.0.0.1:3306/",
            "projetjavab2_161076",
            "root",
            ""
        );
        db.instanciate();



        // Closing the connection to the db
        try{
            db.conn.close();
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
