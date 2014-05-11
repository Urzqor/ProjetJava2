import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout {

    public String title;
    public int height;
    public int width;
    public JFrame jf;
    public Windows window;

    public User user;

    // Constructeur
    public Layout(int h, int w, String title, User user){

        this.height = h;
        this.width = w;
        this.title = title;
        this.window = new Windows();
        this.user = user;
    }

    public void init(){

        this.jf = new JFrame();
        this.jf.setSize(this.width, this.height);

        this.jf.setTitle(this.title);
        this.jf.setVisible(true);
        this.jf.setResizable(false);
        this.jf.setDefaultCloseOperation(3);

        this.jf.setLocationRelativeTo(null);

        Container c = this.jf.getContentPane();
        FlowLayout flow = new FlowLayout();
        c.setLayout(flow);
    }

    public void destroy(){

        this.jf.dispose();
        this.jf = null;
    }
}
