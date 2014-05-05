/**
 * Created by hugocampora on 05/05/14.
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Tutorial extends JFrame
{
    JPanel jp = new JPanel();
    JLabel jl = new JLabel();

    public Tutorial()
    {
        setTitle("Tutorial");
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);

        jl.setIcon(new ImageIcon("src/Logo.png"));
        jp.add(jl);
        add(jp);

        validate();
    }

    public static void main(String[] args)
    {
        Tutorial t = new Tutorial();
    }
}