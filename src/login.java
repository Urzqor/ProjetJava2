/**
 * Created by hugocampora on 05/05/14.
 */

import com.sun.tools.internal.ws.wsdl.document.jaxws.*;

import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;

public class login {
    Connection con;
    Statement st;
    ResultSet rs;

    JFrame f = new JFrame("User Login");
    JLabel l = new JLabel("Username");
    JLabel l1 = new JLabel("Password");
    JTextField t = new JTextField(10);
    JTextField t1 = new JTextField(10);
    JButton b = new JButton("login");

    public login() {

        connect();
        frame();

    }

    public void connect() {
        try {
            String driver = com.mysql.jdbc.Driver.class.getName();
            Class.forName(driver);

            String db = "jdbc:mysql://127.0.0.1:8889/projet";
            con = DriverManager.getConnection(db,"root","root");
            st = con.createStatement();
        } catch (Exception ex) {


        }

    }

    public void frame() {

        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.add(l);
        p.add(t);
        p.add(l1);
        p.add(t1);
        p.add(b);

        f.add(p);


        f.validate();

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String user = t.getText().trim();
                    String password = t1.getText().trim();

                    String sql = "select user,password from projet where user = '"+user+"' AND password = '"+password+"'";
                    rs = st.executeQuery(sql);

                    int count = 0;
                    while(rs.next())
                    {

                        count = count + 1;

                    }

                    if (count == 1)
                    {
                        JOptionPane.showMessageDialog(null,"User found, Access Granted");
                    }
                    else if(count > 1)
                    {

                        JOptionPane.showMessageDialog(null,"Duplicate User, Access Denied");

                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null,"User not Found !");

                    }

                }
                catch (Exception ex)
                {

                }
            }
            }

            );
        }


    public static void main(String[] args) {

        new login();


    }


}
