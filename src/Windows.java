import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Windows {

    public ArrayList<JComponent> components = new ArrayList<JComponent>();
    public Layout window = null;

    // MAIN WINDOW
    public void createMainWindow(Layout l){

        l.jf.add(new JLabel(new ImageIcon("content/logo.png")));

        JLabel label = new JLabel(
                "Log in if you already have an account, "+
                        "or register a new one.",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(30, 100, 50, 100));
        l.jf.add(label);

        JButton button = new JButton("Register");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setActionCommand("register");
        button.addActionListener(new LandingPageActions());
        l.jf.add(button);
        this.components.add(button);

        button = new JButton("Log in");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setActionCommand("login");
        button.addActionListener(new LandingPageActions());
        l.jf.add(button);
        this.components.add(button);

        l.jf.validate();
        this.window = l;
    }


    // REGISTER WINDOW
    public void createRegisterWindow(Layout l){

        JLabel label = new JLabel(
                "Please enter following information :",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(10, 60, 30, 60));
        l.jf.add(label);

        JLabel la = new JLabel("Username : ",JLabel.CENTER);
        la.setBorder(new EmptyBorder(0, 10, 0, 0));
        JLabel la1 = new JLabel("Password : ", JLabel.CENTER);
        la1.setBorder(new EmptyBorder(0, 10, 0, 0));
        JLabel la2 = new JLabel("Repeat psw : ", JLabel.CENTER);
        la2.setBorder(new EmptyBorder(0, 2, 0, 0));
        JTextField tf = new JTextField(10);
        tf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 60, 0, 60)));
        JTextField tf1 = new JTextField(10);
        tf1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 60, 0, 60)));
        JTextField tf2 = new JTextField(10);
        tf2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 60, 0, 60)));
        JCheckBox type = new JCheckBox("Manager", false);
        JButton reg = new JButton("Register");
        reg.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 40, 10, 40)));
        reg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reg.setActionCommand("try_reg_user");
        reg.addActionListener(new LandingPageActions());

        this.components.add(reg);
        this.components.add(tf);
        this.components.add(tf1);
        this.components.add(tf2);
        this.components.add(type);

        l.jf.add(la);
        l.jf.add(tf);
        l.jf.add(la1);
        l.jf.add(tf1);
        l.jf.add(la2);
        l.jf.add(tf2);
        l.jf.add(type);
        l.jf.add(reg);

        l.jf.validate();
        l.jf.toFront();

        this.window = l;
    }

    // LOGIN WINDOW
    public void createLoginWindow(Layout l){

        JLabel label = new JLabel(
                "Please enter your informations :",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(10, 80, 30, 80));
        l.jf.add(label);

        JLabel la = new JLabel("Username : ",JLabel.CENTER);
        la.setBorder(new EmptyBorder(0, 10, 0, 0));
        JLabel la1 = new JLabel("Password : ", JLabel.CENTER);
        la1.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField tf = new JTextField(10);
        tf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 60, 0, 60)));
        JTextField tf1 = new JTextField(10);
        tf1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 60, 0, 60)));
        JButton reg = new JButton("Login");
        reg.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 40, 10, 40)));
        reg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reg.setActionCommand("try_log_user");
        reg.addActionListener(new LandingPageActions());

        this.components.add(reg);
        this.components.add(tf);
        this.components.add(tf1);

        l.jf.add(la);
        l.jf.add(tf);
        l.jf.add(la1);
        l.jf.add(tf1);
        l.jf.add(reg);

        l.jf.validate();
        l.jf.toFront();

        this.window = l;

    }

    // CREATING DASHBOARD WINDOW
    public void createDashboardWindow(Layout l){

        l.jf.add(new JLabel(new ImageIcon("content/logo.png")));

        JLabel label = new JLabel(
                "Welcome, "+l.user.name+".",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(30, 200, 50, 200));
        l.jf.add(label);

        l.jf.validate();
        this.window = l;
    }


    // SWITCH ACTIONS
    public class LandingPageActions implements ActionListener {

        public void actionPerformed(ActionEvent e){

            Object src = e.getSource();

            if ("register".equals(e.getActionCommand())){

                Layout registerWindow = new Layout(220,400,"Register", window.user);
                registerWindow.init();
                registerWindow.window.createRegisterWindow(registerWindow);

                window.destroy();
            }

            if ("login".equals(e.getActionCommand())){

                Layout loginWindow = new Layout(200,400,"Login", window.user);
                loginWindow.init();
                loginWindow.window.createLoginWindow(loginWindow);

                window.destroy();
            }

            if ("try_reg_user".equals(e.getActionCommand())){

                // Trying to register the user
                JTextField usr = (JTextField) components.get(1);
                JTextField psw1 = (JTextField) components.get(2);
                JTextField psw2 = (JTextField) components.get(3);
                JCheckBox type = (JCheckBox) components.get(4);

                if (!usr.getText().trim().equals("") &&
                        !psw1.getText().trim().equals("") &&
                        !psw2.getText().trim().equals("")
                ){
                    if ( psw1.getText().trim().equals( psw2.getText().trim() ) ){

                        if (type.isSelected()){
                            window.user.isManager = true;
                        }

                        if (!window.user.register(usr.getText().trim(), psw1.getText().trim())){
                            JOptionPane.showMessageDialog(null,"This username already exists !");
                        }else{
                            JOptionPane.showMessageDialog(null,"User successfully registered !");

                            Layout mainWindow = new Layout(400,600,"SupPlanner", window.user);
                            mainWindow.init();
                            mainWindow.window.createMainWindow(mainWindow);

                            window.destroy();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Passwords do not match ! Please try again.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Please fill all the fields accordingly.");
                }
            }

            if ("try_log_user".equals(e.getActionCommand())){

                // Trying to log the user in
                JTextField usr = (JTextField) components.get(1);
                JTextField psw1 = (JTextField) components.get(2);

                if (!usr.getText().trim().equals("") && !psw1.getText().trim().equals("")){
                    if (!window.user.login(usr.getText().trim(), psw1.getText().trim())){
                        JOptionPane.showMessageDialog(null, "Wrong information ! Please try again.");
                    }else{

                        if (window.user.connect()){

                            Layout dashWindow = new Layout(400,600,"SupPlanner dashboard", window.user);
                            dashWindow.init();
                            dashWindow.window.createDashboardWindow(dashWindow);

                            window.destroy();
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to connect the user. Try again.");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please fill all the fields accordingly.");
                }
            }
        }
    }
}
