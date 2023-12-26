public  class MeleeWeapon extends Weapons  {
    private  boolean fireSupported;
    private boolean fired;
    private int damage;
    private int cost;
    private String name;
    private double effectiveRange=0;  //ı will handle it .

    @Override
    public double getEffectiveRange() {
        return effectiveRange;
    }


    /**
     * Constructs a MeleeWeapon object:
     * @param name the name of the melee weapon
     * @param fireSupported indicates if the melee weapon can be fired
     * @param cost the cost of the melee weapon
     */
    public MeleeWeapon( String name,int cost,int damage,boolean fireSupported,double effectiveRange){
        super(name,cost,damage,effectiveRange);
        this.fireSupported = fireSupported;
        this.fired = false;
        if (isFired()){
            damage =25;
        }else {
            damage =15;
        }
        this.cost = cost;
        this.name = name;

    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isFireSupported() {
        return fireSupported;
    }

    public void setFireSupported(boolean fireSupported) {
        this.fireSupported = fireSupported;
    }

    public boolean isFired() {
        return fired;
    }

    public int getDamage() {
        if (isFired()){
            damage =25;
        }else {
            damage =15;
        }
        return damage;
    }

    @Override
    public String getInfo() {
        return null;
    }

    public int getCost() {
        return cost;
    }


    public String getName() {
        return name;
    }

}
