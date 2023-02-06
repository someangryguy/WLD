public class Character {
    private String name;
    private int hp, damage, armour,maxHp;

    ArmourType armourType;

    public Character(String name, int hp, int damage, int armour, ArmourType armourType) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.armour = armour;
        this.maxHp = hp;
        this.armourType = armourType;
    }

    boolean isAlive(){
        return hp > 0;
    }


    /*-----------------------------------------Getter + Setter-----------------------------------------*/
    public String getName(){
        return name + "(" + getHP() + "/" + maxHp + ")";
    }

    public int getHP(){
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
}
