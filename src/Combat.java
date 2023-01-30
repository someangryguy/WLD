import java.sql.SQLOutput;

public class Combat {
    Character player, enemy;

    public Combat(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
        System.out.println("----------------" +
                player.getName() + " is about to fight " + enemy.getName() + "!" + "----------------");
        dramaticPause(1);// milisekundy
    }

    void duel(){
        while (player.isAlive() && enemy.isAlive()){
            dramaticPause(1);
            attack(player, enemy);
            dramaticPause(1);
            attack(enemy, player);
        }
        dramaticPause(1);
        if(player.isAlive()){
            Player p = (Player) player;
            Enemy e = (Enemy) enemy; //přetypujeme oba charaktery

            p.setExpPoints(p.getExpPoints() + e.getExpReward());// Reward player with exp
            System.out.println(player.getName() + " killed " + enemy.getName() + "!");
        }else{
            System.out.println(player.getName() + "was killed by " + enemy.getName() + "!");
        }
    }

    void attack(Character attacker, Character defender){
        if(!attacker.isAlive() || !defender.isAlive()){
            return;

        }

        int reducedDmg = attacker.getDamage() - defender.getArmour();

        int damageToDo = RandomNumInRange(reducedDmg - (reducedDmg * 0.1), reducedDmg + (reducedDmg * 0.1));
        damageToDo = damageToDo >= defender.getHP() ? defender.getHP() : damageToDo;//zabrání jít hp do minusu



        if(damageToDo <= defender.getArmour()){ //if armour is bigger than damage then set it to 1
            damageToDo = 1;
        }


        defender.setHP(defender.getHP() - damageToDo);
        System.out.println(attacker.getName() + " attacked " + defender.getName() + " and dealt " + damageToDo + " damage to them!");
    }

    public static int RandomNumInRange(double min, double max){
        return  (int) (Math.random() * (max - min + 1) + min);
    }

    void dramaticPause(int seconds){
        try{
            Thread.sleep(seconds * 1000); //
        }catch (InterruptedException e){
            System.out.println("Thread died ");
        }

    }
}
