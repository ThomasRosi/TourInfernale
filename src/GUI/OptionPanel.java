package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * Created by Arnau on 16/03/2017.
 */
public class OptionPanel extends JPanel{

    private Color c1 = new Color(137, 76, 39);
    private Color c2 = new Color(112, 31, 9);
    private Color c3 = new Color(232, 169, 54);


    public OptionPanel(){
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
        System.out.println("");
        Graphics2D g = (Graphics2D) g1;

        g.setColor(c1);
        g.fillRect(3*w, h, 5*w, 2*h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 90));
        if(MyFrame.isEn){
            g.drawString(MyFrame.en[3], 3*w+60,  5*(h/2));
        } else {
            g.drawString(MyFrame.fr[3], 3*w+60,  5*(h/2));
        }

        g.setColor(c2);
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(3*w,h,8*w,h);
        g.drawLine(8*w,3*h,3*w, 3*h);
        g.drawLine(3*w,h,3*w ,3*h);
        g.drawLine(8*w,3*h,8*w,h);

        g.setColor(c3);
        g.setFont(new Font("Arial", Font.PLAIN,60));
        if(MyFrame.isEn){
            g.drawString(MyFrame.en[13], 2*w, 5*h);
        } else {
            g.drawString(MyFrame.fr[13], 2*w, 5*h);
        }

    }
}
