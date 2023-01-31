import java.util.Scanner;

public class Level {
    private Dungeon dungeon;
    private String name;

    private boolean proceedToNextLevel = false;

    public Level(Dungeon dungeon, String name) {
        this.dungeon = dungeon;
        this.name = name;
    }

    //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
    public boolean NextLevel() {
        return proceedToNextLevel;
    }
    void levelHub(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("===" + this.name + "===");

        System.out.println("1: Enter Dungeon " + dungeon.getName());
        System.out.println("2: Rest (heal)");
        System.out.println("3: Proceed (next level)");
        int choice = scanner.nextInt();

    }
}
