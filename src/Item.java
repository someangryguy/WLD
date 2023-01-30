public class Item {
    String name;
    int attackBuff;
    int armourBuff;

    DamageType damageType;

    public Item(String name, int attackBuff, int armourBuff, DamageType damageType) {
        this.name = name;
        this.attackBuff = attackBuff;
        this.armourBuff = armourBuff;
        this.damageType = damageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBuff() {
        return attackBuff;
    }

    public void setAttackBuff(int attackBuff) {
        this.attackBuff = attackBuff;
    }

    public int getArmourBuff() {
        return armourBuff;
    }

    public void setArmourBuff(int armourBuff) {
        this.armourBuff = armourBuff;
    }

    @Override
    public String toString() {
        return "-------------" + name + "------------- \n" +
                "Attack Buff " + attackBuff + "\n" +
                "Armour Buff " + armourBuff;
    }
}
