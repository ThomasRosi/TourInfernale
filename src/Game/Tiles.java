package Game;

import java.awt.*;

/**
 * Created by Thomas on 08-03-17.
 */
public class Tiles {

    private int x, y;
    private boolean isWall, isStart, isEnd, isPlayer, isKnew, isKey, isTrap, isHeart, isStar;
    private Color color;

    public Tiles() {
        this(0, 0, false, false, false, false, false, false, false, false, false, Color.BLACK);
    }

    public Tiles(int x, int y, boolean isWall, boolean isStart, boolean isEnd, boolean isPlayer, boolean isKnew, boolean isKey, boolean isTrap, boolean isHeart, boolean isStar, Color color) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        this.isStart = isStart;
        this.isEnd = isEnd;
        this.isPlayer = isPlayer;
        this.isKnew = isKnew;
        this.isKey = isKey;
        this.isTrap = isTrap;
        this.isHeart = isHeart;
        this.isStar = isStar;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setIsWall(boolean isWall) {
        this.isWall = isWall;
    }

    public boolean getIsWall() {
        return isWall;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean getIsStart() {
        return isStart;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public boolean getIsPlayer() {
        return isPlayer;
    }

    public void setIsKnew(boolean isKnew) {
        this.isKnew = isKnew;
    }

    public boolean getIsKnew() {
        return isKnew;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }

    public boolean getIsKey() {
        return isKey;
    }

    public void setIsTrap(boolean isTrap) {
        this.isTrap = isTrap;
    }

    public boolean getIsTrap() {
        return isTrap;
    }

    public void setIsHeart(boolean isHeart) {
        this.isHeart = isHeart;
    }

    public boolean getIsHeart() {
        return isHeart;
    }

    public void setIsStar(boolean isStar) {
        this.isStar = isStar;
    }

    public boolean getIsStar() {
        return isStar;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}