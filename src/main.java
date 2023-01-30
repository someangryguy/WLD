import java.sql.SQLOutput;
import java.util.Scanner;

public class main {

    static void initialize(){
        // TODO: 16.01.2023 --> připravit postavy při spuštění hry
    }

    static Player loadInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose character name:");
        String name = scanner.nextLine();
        System.out.println("Set HP");
        int hp = scanner.nextInt();
        System.out.println("Set damage");
        int damage = scanner.nextInt();
        System.out.println("Set armour");
        int armour = scanner.nextInt();


        return new Player(name, hp, damage, armour, 0, ArmourType.ARMORED);
    }

    static void GetWeapon(Player player){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose weapon name: ");
        String name = scanner.nextLine();
        System.out.println("Choose weapon defense: ");
        int defense = scanner.nextInt();
        System.out.println("Choose weapon attack power: ");
        int attack = scanner.nextInt();

        Item itemToEquip = new Item(name, attack, defense, DamageType.SLASH);
        player.equipItem(itemToEquip);
        System.out.println(itemToEquip.toString());

    }

    public static void main(String[] args) {
        System.out.println("Run the game.");

        /*
        * Player player = loadInfo();
        GetWeapon(player);
        * */
        Player player = new Player("741", 741, 0,5,0, ArmourType.ARMORED);
        player.equipItem(new Item("Sword", 20, 0, DamageType.SLASH));
        while (player.isAlive()){
            Enemy enemy = new Enemy("Wolf", 30, 15, 5, 20, ArmourType.HIDE);
            Combat combat = new Combat(player, enemy);
            combat.duel();

        }

        System.out.println("------------------------------------Game over!------------------------------------)");
        System.out.println(player.getName() + " has died! The world moves on tho ;).");

        System.out.println("You scored " + player.getExpPoints() + " Exp." +  "Try again.");
    }
}
