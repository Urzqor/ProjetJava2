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

        Layout mainWindow = new Layout(400,600,"SupPlanner");
        mainWindow.init();
        mainWindow.createMainWindow();

        User user = new User();

    }
}
