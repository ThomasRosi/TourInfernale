package Game;

import java.awt.*;
import java.io.*;

/**
 * Created by Thomas on 08-03-17.
 */
public class Stage {

    private Tiles[][] stage = new Tiles[50][50];
    private Character c;
    private String fichier;
    private int num;
    private int star = 0;

    public Stage(int num, Character c){
        this.num = num;
        this.c = c;
        this.fichier = "resources/stages/stage1.txt";
        switch (num){
            case 1:
                fichier = "resources/stages/stage1.txt";
                break;
            case 2:
                fichier = "resources/stages/stage2.txt";
                break;
            case 3:
                fichier = "resources/stages/stage3.txt";
                break;
            case 4:
                fichier = "resources/stages/stage4.txt";
                break;
            case 5:
                fichier = "resources/stages/stage5.txt";
                break;
            case 6:
                fichier = "resources/stages/stage6.txt";
                break;
            case 7:
                fichier = "resources/stages/stage7.txt";
                break;
            case 8:
                fichier = "resources/stages/stage8.txt";
                break;
            case 9:
                fichier = "resources/stages/stage9.txt";
                break;
            case 10:
                fichier = "resources/stages/stage10.txt";
                break;
            default:
                System.out.println("Error");
        }

        reset();
    }


    public Tiles getTiles(int x, int y){
        return stage[x][y];
    }

    public void reset(){

        File f = new File(fichier);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            int x;
            int i = 0, j = 0;
            while ((x = br.read()) != -1) {
                int n = Integer.parseInt(String.valueOf((char) x));
                switch (n) {
                    case 0:
                        stage[i][j] = new Tiles(i, j, false, false, false, false, false, false, false, false, false, Color.BLACK);
                        break;
                    case 1:
                        stage[i][j] = new Tiles(i, j, true, false, false, false, false, false, false, false, false, Color.BLUE);
                        break;
                    case 2:
                        stage[i][j] = new Tiles(i, j, false, true, false, true, false, false, false, false, false, Color.GREEN);
                        break;
                    case 3:
                        stage[i][j] = new Tiles(i, j, false, false, true, false, false, false, false, false, false, Color.RED);
                        break;
                    case 4:
                        stage[i][j] = new Tiles(i, j, false, false, false, false, false, true, false, false, false, Color.BLACK);
                        break;
                    case 5:
                        stage[i][j] = new Tiles(i, j, false, false, false, false, false, false, true, false, false, Color.BLACK);
                        break;
                    case 6:
                        stage[i][j] = new Tiles(i, j, false, false, false, false, false, false, false, true, false, Color.BLACK);
                        break;
                    case 7:
                        stage[i][j] = new Tiles(i, j, false, false, false, false, false, false, false, false, true, Color.BLACK);
                        break;
                    default:
                        System.out.println("Error");
                }
                i++;
                if(i == 50) {
                    br.readLine();
                    j++;
                    i = 0;
                }
            }
            br.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        c.setHasKey(false);
        c.setLife(3);
        star = 0;
        setBlack();
        setColor();
    }

    private void repaint(){
        setBlack();
        setColor();
    }

    private void setBlack(){
        for (int i = 1; i < 49; i++) {
            for (int j = 1; j < 49; j++) {
                if(stage[i][j].getIsKnew()){
                    setGray(stage[i][j]);
                } else {
                    stage[i][j].setColor(Color.BLACK);
                }
            }
        }
    }

    private void setColor(){
        Tiles t = findPlayer();
        int i = t.getX();
        int j = t.getY();
        t.setColor(Color.ORANGE);
        if(i != 1) {
            setWhite(stage[i-1][j]);
            if(j != 1){
                setWhite(stage[i-1][j-1]);
                if(!stage[i-1][j-1].getIsWall() && !stage[i-1][j].getIsWall() && !stage[i][j-1].getIsWall()){
                    setWhite(stage[i-1][j-2]);
                    setWhite(stage[i-2][j-1]);
                }
            }
            if(!stage[i-1][j].getIsWall()){
                setWhite(stage[i-2][j]);
                if(!stage[i-2][j].getIsWall()){
                    setWhite(stage[i-3][j]);
                }
            }
        }

        if(i != 49) {
            setWhite(stage[i+1][j]);
            if(j != 49){
                setWhite(stage[i+1][j+1]);
                if(!stage[i+1][j+1].getIsWall() && !stage[i+1][j].getIsWall() && !stage[i][j+1].getIsWall()){
                    setWhite(stage[i+1][j+2]);
                    setWhite(stage[i+2][j+1]);
                }
            }
            if(!stage[i+1][j].getIsWall()){
                setWhite(stage[i+2][j]);
                if(!stage[i+2][j].getIsWall()){
                    setWhite(stage[i+3][j]);
                }
            }

        }

        if(j != 1) {
            setWhite(stage[i][j-1]);
            if(i != 49){
                setWhite(stage[i+1][j-1]);
                if(!stage[i+1][j-1].getIsWall() && !stage[i+1][j].getIsWall() && !stage[i][j-1].getIsWall()){
                    setWhite(stage[i+1][j-2]);
                    setWhite(stage[i+2][j-1]);
                }
            }
            if(!stage[i][j-1].getIsWall()){
                setWhite(stage[i][j-2]);
                if(!stage[i][j-2].getIsWall()){
                    setWhite(stage[i][j-3]);
                }
            }
        }

        if(j != 49) {
            setWhite(stage[i][j+1]);
            if(i != 1){
                setWhite(stage[i-1][j+1]);
                if(!stage[i-1][j+1].getIsWall() && !stage[i-1][j].getIsWall() && !stage[i][j+1].getIsWall()){
                    setWhite(stage[i-1][j+2]);
                    setWhite(stage[i-2][j+1]);
                }
            }
            if(!stage[i][j+1].getIsWall()){
                setWhite(stage[i][j+2]);
                if(!stage[i][j+2].getIsWall()){
                    setWhite(stage[i][j+3]);
                }
            }
        }
    }



    private void setWhite(Tiles t){
        t.setIsKnew(true);
        if(t.getIsStart()){
            t.setColor(Color.GREEN);
        } else if(t.getIsEnd()){
            t.setColor(Color.RED);
        } else if(t.getIsWall()) {
            t.setColor(Color.BLUE);
        } else {
            t.setColor(Color.WHITE);
        }
    }

    private void setGray(Tiles t){
        if(t.getIsStart()){
            t.setColor(Color.GREEN);
        } else if(t.getIsEnd()){
            t.setColor(Color.RED);
        } else if(t.getIsWall()){
            t.setColor(Color.BLUE);
        } else {
            t.setColor(Color.GRAY);
        }
    }


    public void moveUp(){
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        if(!stage[x-1][y].getIsWall()) {
            stage[x][y].setIsPlayer(false);
            stage[x-1][y].setIsPlayer(true);
        }
        if(isOnKey()){
            t = findPlayer();
            t.setIsKey(false);
            c.setHasKey(true);
        }
        if(isOnTrap()){
            c.setLife(c.getLife()-1);
        }
        if(isOnHeart() && c.getLife() != 3){
            c.setLife(c.getLife()+1);
        }
        if(isOnStar()) {
            star++;
        }
        repaint();
    }

    public void moveDown(){
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        if(!stage[x+1][y].getIsWall()) {
                stage[x][y].setIsPlayer(false);
                stage[x+1][y].setIsPlayer(true);
        }
        if(isOnKey()){
            t = findPlayer();
            t.setIsKey(false);
            c.setHasKey(true);
        }
        if(isOnTrap()){
            c.setLife(c.getLife()-1);
        }
        if(isOnHeart() && c.getLife() != 3){
            c.setLife(c.getLife()+1);
        }
        if(isOnStar()) {
            star++;
        }
        repaint();
    }

    public void moveLeft(){
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        if(!stage[x][y-1].getIsWall()) {
            stage[x][y].setIsPlayer(false);
            stage[x][y-1].setIsPlayer(true);
        }
        if(isOnKey()){
            t = findPlayer();
            t.setIsKey(false);
            c.setHasKey(true);
        }
        if(isOnTrap()){
            c.setLife(c.getLife()-1);
        }
        if(isOnHeart() && c.getLife() != 3){
            c.setLife(c.getLife()+1);
        }
        if(isOnStar()) {
            star++;
        }
        repaint();
    }

    public void moveRight() {
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        if(!stage[x][y+1].getIsWall()) {
            stage[x][y].setIsPlayer(false);
            stage[x][y+1].setIsPlayer(true);
        }
        if(isOnKey()){
            t = findPlayer();
            t.setIsKey(false);
            c.setHasKey(true);
        }
        if(isOnTrap()){
            c.setLife(c.getLife()-1);
        }
        if(isOnHeart() && c.getLife() != 3){
            c.setLife(c.getLife()+1);
        }
        if(isOnStar()) {
            star++;
        }
        repaint();
    }

    private Tiles findPlayer() {
        Tiles t = new Tiles();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 49; j++) {
                if (stage[i][j].getIsPlayer()) {
                    t = stage[i][j];
                }
            }
        }
        return t;
    }

    private boolean isOnKey() {
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if(stage[i][j].getIsKey()){
                    if(x == i && j == y){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isOnTrap() {
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if(stage[i][j].getIsTrap()){
                    if(x == i && j == y){
                        stage[i][j].setIsTrap(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isOnHeart() {
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if(stage[i][j].getIsHeart() && c.getLife() != 3){
                    if(x == i && j == y){
                        stage[i][j].setIsHeart(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isOnStar() {
        Tiles t = findPlayer();
        int x = t.getX();
        int y = t.getY();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if(stage[i][j].getIsStar()){
                    if(x == i && j == y){
                        stage[i][j].setIsStar(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getStar(){
        return star;
    }

    public boolean isWon(){
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if(stage[i][j].getIsPlayer()){
                    x1 = i;
                    y1 = j;
                }
                if(stage[i][j].getIsEnd()){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if(x1 == x2 && y1 == y2 && c.getHasKey()){
            return true;
        } else {
            return false;
        }
    }

    public int getNum(){
        return num;
    }

}