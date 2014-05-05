import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Layout {

    public String title;
    public int height;
    public int width;
    public JFrame jf;

    // Constructeur
    public Layout(int h, int w, String title){

        this.height = h;
        this.width = w;
        this.title = title;
    }

    public void init(){

        this.jf = new JFrame();
        this.jf.setSize(this.width, this.height);

        this.jf.setTitle(this.title);
        this.jf.setVisible(true);
        this.jf.setResizable(false);
        this.jf.setDefaultCloseOperation(3);

        this.jf.setLocation(100,100);

        Container c = this.jf.getContentPane();
        FlowLayout flow = new FlowLayout();
        c.setLayout(flow);
    }

    public void createMainWindow(){

        this.jf.add(new JLabel(new ImageIcon("content/logo.png")));

        JLabel label = new JLabel(
            "Connectez-vous si vous possédez déjà un compte, "+
            "ou enregistrez un nouveau compte.",
            JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(10, 0, 30, 0));
        this.jf.add(label);

        JButton button = new JButton("S'enregistrer");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.jf.add(button);

        button = new JButton("S'enregistrer");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.jf.add(button);

        this.jf.validate();
    }
}
