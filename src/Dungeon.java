import java.util.ArrayList;

public class Dungeon {
    private int reward;
    private ArrayList<Enemy> enemies;
    private String name;
//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
    public Dungeon(String name, int reward) {
        this.name = name;
        this.reward = reward;
        enemies = new ArrayList<>();
    }

    boolean isCompleted(){
        return enemies.size() == 0;
    }

    Enemy popEnemy(){
        Enemy toPop = enemies.get(0);
        enemies.remove(0);
        return toPop;
    }

    public void addEnemy(Enemy monster){
        enemies.add(monster);
    }

    public int getReward(){
        return reward;
    }
    public String getName(){
        return name;
    }
}