package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Thomas on 08-03-17.
 */
public class MenuBouton extends JButton {

    private Color c1 = new Color(137, 76, 39);
    private Color c2 = new Color(112, 31, 9);
    private Color c3 = new Color(88, 43, 28);

    public MenuBouton(String text, int xPos, int yPos, int bWidth, int bHeight) {
        this.setBackground(c1);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 50));
        this.setText(text);
        this.setBorder(BorderFactory.createEtchedBorder(c2, c2));
        this.setBounds(xPos, yPos, bWidth, bHeight);
        this.setFocusPainted(false);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(c1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(c3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(c1);
            }
        });
    }
}
