package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 22-02-17.
 */
public class HelpPanel extends JPanel {

    private Color c1 = new Color(137, 76, 39);
    private Color c2 = new Color(112, 31, 9);
    private Color c3 = new Color(232, 169, 54);

    public HelpPanel() {
        super();
        this.setLayout(null);
    }

    public void paintComponent(Graphics g1){

        int w = (this.getSize().width)/11, h = (this.getSize().height)/10;

        try{
            Image img = ImageIO.read(new File("resources/img/fond.jpg"));
            g1.drawImage(img, 0,0,getWidth(),getHeight(),this);
        } catch (IOException e){
            e.printStackTrace();
        }

        Graphics2D g = (Graphics2D) g1;

        g.setColor(c1);
        g.fillRect(3*w, h, 5*w, 2*h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 90));
        if(MyFrame.isEn){
            g.drawString(MyFrame.en[1], 4*w + 30,  5*(h/2));
        } else {
            g.drawString(MyFrame.fr[1], 4*w + 30,  5*(h/2));
        }

        g.setColor(c2);
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(3*w,h,8*w,h);
        g.drawLine(8*w,3*h,3*w, 3*h);
        g.drawLine(3*w,h,3*w ,3*h);
        g.drawLine(8*w,3*h,8*w,h);

        g.setColor(c3);
        g.setFont(new Font("Arial", Font.PLAIN,20));
        if(MyFrame.isEn){
            for (int i =7; i<=12;i++) {
                g.drawString(MyFrame.en[i], w, (9*h/2) + ((h / 2) * (i - 7)));
            }
        } else {
            for (int i =7; i<=12;i++)
                g.drawString(MyFrame.fr[i], w, (9*h/2) + ((h/2)*(i-7)));
        }


    }

}
