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

        // Connection to the database
        Database db = new Database(
            "jdbc:mysql://127.0.0.1:3306/",
            "projetjavab2_161076",
            "root",
            ""
        );
        db.instanciate();

        // Creating an empty user
        User user = new User(db);

        // Loading landing screen
        Layout mainWindow = new Layout(400,600,"SupPlanner", user);
        mainWindow.init();
        mainWindow.window.createMainWindow(mainWindow);

        // Disconnecting from running connection
        // user.disconnect();
    }
}
