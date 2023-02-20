import java.util.Scanner;

public class Level {
    private Dungeon dungeon;
    private String name;
    private boolean proceed, quit;
    private Player player;
    private Level next;
    Level(String name, Dungeon dung, Player player, Level next){
        this.name = name;
        this.player = player;
        this.dungeon = dung;
        this.next = next;
        proceed = false;
        quit = false;
    }

    public boolean nextLevel() {
        return proceed;
    }
    public boolean isFinished(){
        return quit;
    }

    public void setNext(Level next) {
        this.next = next;
    }

    void heal(){
        int toHeal = player.getMaxHp() / 2;



        if(player.getHP() + toHeal > player.getMaxHp()){

            System.out.println("Healing " + player.getName()  +  " for " + (player.getMaxHp() - player.getHP()) + "HP...");
            player.setHP(player.getMaxHp());
        }else{
            player.setHP(player.getHP() + toHeal);
            System.out.println("Healing " + player.getName() + " for " + toHeal + "HP...");
        }

        player.setHealTokens(player.getHealTokens()-1);
        if(player.getHealTokens() < 0)
            player.setHealTokens(0);
    }

    void levelHub(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===" + this.name + "===");
        System.out.println(player.getName() + " has " + player.getHealTokens() + " heal tokens.");
        System.out.println(player.getName() + " has " + player.getExpPoints() + " exp");
        System.out.println("1: Enter dungeon: " + dungeon.getName());
        System.out.println("2: rest (heal)");
        System.out.println("3: Proceed (next level)");
        System.out.println("4: Buy health token (1000exp)");
        // TODO: 06.02.2023 přidat funkční shop a víc možností nákupu
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Entering the .... " + dungeon.getName());
                enterDungeon();
                break;
            case 2:
                if(player.getHealTokens() > 0){
                    heal();
                }else{
                    System.out.println("You have no heal tokens.");
                }
                break;
            case 3:
                if(nextLevel()){
                    System.out.println("Proceeding to the next level");
                    if(this.next == null){
                        System.out.println("U completed all the levels there is nothing left");

                    }
                    quit = true;
                }else{
                    System.out.println("You have to complete " + dungeon.getName() + " first!");
                }
                break;
            case 4:

            default:
                System.out.println("Wrong choice");
                break;
        }
    }

    void enterDungeon(){
        Combat dungeonCombat;
        while(player.isAlive() && !dungeon.isCompleted()){
            dungeonCombat = new Combat(player, dungeon.popEnemy());
            dungeonCombat.duel();
        }

        if(player.isAlive()){
            System.out.println(player.getName() + " has completed the dungeon");
            player.setExpPoints(player.getExpPoints() + dungeon.getReward());
            player.setHealTokens(player.getHealTokens() + 1);
            proceed = true;
        }else{
            System.out.println(player.getName() + " has died in the dungeon");
            quit = false;
        }


    }
}
