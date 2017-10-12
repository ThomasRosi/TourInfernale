package Game;

/**
 * Created by Thomas on 11-03-17.
 */
public class Character {

    private int life = 3;
    private boolean hasKey = false;
    private int level = 0;
    private int[] starTab = new int[10];

    public Character() {
        for(int i = 0; i < starTab.length; i++){
            starTab[i] = 0;
        }
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean getHasKey() {
        return hasKey;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setStarIndex(int i, int s){
        starTab[i] = s;
    }

    public int getStarIndex(int i){
        return starTab[i];
    }
}
