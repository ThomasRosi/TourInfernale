package GUI;

import Game.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 08-03-17.
 */
public class LevelPanel extends JPanel {

    private Color c1 = new Color(137, 76, 39);
    private Color c2 = new Color(112, 31, 9);
    private Character c;

    public LevelPanel(Character c) {
        super();
        setLayout(null);
        this.c = c;
    }

    public void paintComponent(Graphics g1) {

        int w = (this.getSize().width)/11, h = (this.getSize().height)/10;

        try{
            Image img = ImageIO.read(new File("resources/img/fond.jpg"));
            g1.drawImage(img, 0,0,getWidth(),getHeight(),this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g = (Graphics2D) g1;

        g.setColor(c1);
        g.fillRect(w, h, 9*w, 2*h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 90));
        if(MyFrame.isEn){
            g.drawString(MyFrame.en[4], w + 30,  5*(h/2));
        } else {
            g.drawString(MyFrame.fr[4], w + 15,  5*(h/2));
        }

        g.setColor(c2);
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(w, h, 10*w, h);
        g.drawLine(w, h, w, 3*h);
        g.drawLine(10*w, h, 10*w, 3*h);
        g.drawLine(w, 3*h, 10*w, 3*h);

        int x = 77;
        for(int i = 0; i < c.getLevel(); i++) {
            try {
                Image img = ImageIO.read(new File("resources/img/unlocked.png"));
                g.drawImage(img, 100 + i * (x + 5), 390, x, x, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int i = 9; i > c.getLevel(); i--) {
            try {
                Image img = ImageIO.read(new File("resources/img/locked.png"));
                g.drawImage(img, 100 + i * (x + 5), 390, x, x, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int pos = 110;
        for(int i = 0; i < 10; i++){
            int starNbr = c.getStarIndex(i);
            for (int j = 0; j < 3; j++) {
                if(j < starNbr){
                    try {
                        System.out.println();
                        Image img = ImageIO.read(new File("resources/img/yellowStar.png"));
                        g.drawImage(img, pos, 280, 18, 18, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Image img = ImageIO.read(new File("resources/img/blackStar.png"));
                        g.drawImage(img, pos, 280, 18, 18, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                pos += 18;
            }
            pos += 28;
        }

    }
}
