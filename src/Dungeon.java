import java.util.ArrayList;

public class Dungeon {
    private int reward;
    private ArrayList<Enemy> enemies;
    private String name;


    public Dungeon(String name, int reward){
        this.reward = reward;
        this.name = name;
        enemies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted(){
        return enemies.size() == 0;
    }

    public Enemy popEnemy(){
        Enemy toPop = enemies.get(0);
        enemies.remove(0);
        return toPop;
    }

    public void addEnemy(Enemy monster){
        enemies.add(monster);
    }

    public int getReward() {
        return reward;
    }
}
