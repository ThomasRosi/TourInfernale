package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 08-03-17.
 */
public class MenuPanel extends JPanel {

    private Color c1 = new Color(137, 76, 39);
    private Color c2 = new Color(112, 31, 9);


    public MenuPanel() {
        super();
        this.setLayout(null);
    }

    public void paintComponent(Graphics g1) {

        int w = (this.getSize().width)/11, h = (this.getSize().height)/10;

        try{
            Image img = ImageIO.read(new File("resources/img/fond.jpg"));
            g1.drawImage(img, 0,0,getWidth(),getHeight(),this);
        } catch (IOException e){
            e.printStackTrace();
        }

        Graphics2D g = (Graphics2D) g1;

        g.setColor(c1);
        g.fillRect(w, h, 9*w, 2*h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 90));
        g.drawString("The Infernal Tower", w + w/8,  5*(h/2));
        g.setColor(c2);
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(w, h, 10*w, h);
        g.drawLine(w, h, w, 3*h);
        g.drawLine(10*w, h, 10*w, 3*h);
        g.drawLine(w, 3*h, 10*w, 3*h);

    }
}
