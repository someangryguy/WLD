public class Enemy extends Character{
    private int expReward;
    public Enemy(String name, int hp, int damage, int armour,int expReward, ArmourType armourType) {
        super(name, hp, damage, armour, armourType);
        this.expReward = expReward;
        //asdfsdf
    }






    /*-----------------------------------------Getter + Setter-----------------------------------------*/
    public int getExpReward() {
        return expReward;
    }

    public void setExpReward(int expReward) {
        this.expReward = expReward;
    }
}
