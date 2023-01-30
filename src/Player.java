import java.util.ArrayList;

public class Player extends Character{
    private int expPoints=0;
    private Item equippedItem;



    public Player(String name, int hp, int damage, int armour, int expPoints, ArmourType armourType) {
        super(name, hp, damage, armour, armourType);
        this.expPoints = expPoints;
    }


    void equipItem(Item item){
        if (equippedItem != null){
            dropItem();
        }
        equippedItem = item;
        setDamage(getDamage() + item.attackBuff);
        setArmour(getArmour() + item.armourBuff);

    }

    void dropItem(){
        if(equippedItem == null){
            return;
        }
        setDamage(getDamage() - equippedItem.attackBuff);
        setArmour(getArmour() - equippedItem.armourBuff);
        equippedItem = null;
    }

    @Override
    public int getDamage() {
        int dmg = super.getDamage();
        return dmg;
    }

    /*-----------------------------------------Getter + Setter-----------------------------------------*/
    public int getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(int expPoints) {
        this.expPoints = expPoints;
    }
}
