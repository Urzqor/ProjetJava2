import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Windows {

    public ArrayList<JButton> buttons = new ArrayList<JButton>();
    public Layout window = null;

    // MAIN WINDOW
    public void createMainWindow(Layout l){

        l.jf.add(new JLabel(new ImageIcon("content/logo.png")));

        JLabel label = new JLabel(
                "Connectez-vous si vous possédez déjà un compte, "+
                        "ou enregistrez un nouveau compte.",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(10, 0, 30, 0));
        l.jf.add(label);

        JButton button = new JButton("S'enregistrer");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setActionCommand("register");
        button.addActionListener(new LandingPageActions());
        l.jf.add(button);
        this.buttons.add(button);

        button = new JButton("Se connecter");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setActionCommand("connect");
        button.addActionListener(new LandingPageActions());
        l.jf.add(button);
        this.buttons.add(button);

        l.jf.validate();
        this.window = l;
    }


    // REGISTER WINDOW
    public void createRegisterWindow(Layout l){

        JLabel label = new JLabel(
                "Veuillez entrer les informations suivantes :",
                JLabel.CENTER
        );
        label.setBorder(new EmptyBorder(10, 0, 30, 0));
        l.jf.add(label);


        l.jf.validate();
        l.jf.toFront();
    }

    public class LandingPageActions implements ActionListener {

        public void actionPerformed(ActionEvent e){

            Object src = e.getSource();

            if ("register".equals(e.getActionCommand())){
                Layout registerWindow = new Layout(200,400,"Register");
                registerWindow.init();
                registerWindow.window.createRegisterWindow(registerWindow);

                window.jf.setVisible(false);
                /*JButton buttonSrc = (JButton) src;
                for (JButton b : buttons){
                    if (b.equals(buttonSrc)){
                        b.setEnabled(false);
                    }
                }*/
            }
        }
    }
}
