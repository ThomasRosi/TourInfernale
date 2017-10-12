package GUI;

import Game.Character;
import Game.Stage;
import Game.Tiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thomas on 08-03-17.
 */
public class PlayPanel extends JPanel {

    private Stage stage;
    private Character c;

    public PlayPanel(Stage stage, Character c) {
        super();
        setLayout(null);
        this.c = c;
        this.stage = stage;
    }

    public void paintComponent(Graphics g) {

        int w = 92, h = 76;
        int startX = w+14;
        int startY = h+16;
        int pxX = 16;
        int pxY = 12;

        try {
            Image img = ImageIO.read(new File("resources/img/fond.jpg"));
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setColor(Color.BLACK);
        g.fillRect(startX, startY, 50*pxX, 50*pxY);


        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {

                if(i == 0 || i == 49 || j == 0 || j == 49){
                    try {
                        Image img = ImageIO.read(new File("resources/img/mur.jpg"));
                        g.drawImage(img, startX, startY, pxX, pxY, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Tiles t = stage.getTiles(i,j);
                    if (t.getIsWall() && t.getIsKnew() ) {
                        try {
                            Image img = ImageIO.read(new File("resources/img/mur.jpg"));
                            g.drawImage(img, startX, startY, pxX, pxY, this);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (t.getIsPlayer()) {
                        g.setColor(Color.WHITE);
                        g.fillRect(startX, startY, pxX, pxY);
                        g.setColor(t.getColor());
                        g.fillOval(startX, startY, pxX, pxY);
                    } else {
                        g.setColor(t.getColor());
                        g.fillRect(startX, startY, pxX, pxY);
                        if (t.getIsKey() && t.getIsKnew()) {
                            try {
                                Image img = ImageIO.read(new File("resources/img/clef.png"));
                                g.drawImage(img, startX, startY, pxX, pxY, this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if(t.getIsTrap() && t.getIsKnew()){
                            try {
                                Image img = ImageIO.read(new File("resources/img/trap.png"));
                                g.drawImage(img, startX, startY, pxX, pxY, this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if(t.getIsHeart() && t.getIsKnew()){
                            try {
                                Image img = ImageIO.read(new File("resources/img/heart.png"));
                                g.drawImage(img, startX, startY, pxX, pxY, this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if(t.getIsStar() && t.getIsKnew()) {
                            try {
                                Image img = ImageIO.read(new File("resources/img/yellowStar.png"));
                                g.drawImage(img, startX, startY, pxX, pxY, this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                startX += pxX;
            }
            startY += pxY;
            startX -= 50*pxX;
        }
        if(c.getHasKey()){
            try {
                Image img = ImageIO.read(new File("resources/img/clef.png"));
                g.drawImage(img, 850, 30, 50, 50, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int x = 100;
        for (int i = 0; i < c.getLife(); i++) {
            try {
                Image img = ImageIO.read(new File("resources/img/heart.png"));
                g.drawImage(img, x, 30, 50, 50, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            x += 60;
        }
        x = 450;
        int s = stage.getStar();
        for (int i = 0; i < 3; i++) {
            if(i < s){
                try {
                    Image img = ImageIO.read(new File("resources/img/yellowStar.png"));
                    g.drawImage(img, x, 25, 50, 50, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Image img = ImageIO.read(new File("resources/img/blackStar.png"));
                    g.drawImage(img, x, 25, 50, 50, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            x += 60;
        }
    }

}
