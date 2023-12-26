public    class BowAndArrows extends RangedWeapon {
    private  boolean supportPoison;
    private boolean isPoisoned;
    private  int damage;
    private double effectiveRange;
    private int arrowCount;
    private int cost;
    private String name;
    private  double misfireRate;
    public BowAndArrows(String name, int cost, double effectiveRange, int damage, boolean supportPoison){

        super(name, cost,  damage,effectiveRange);
        this.supportPoison = supportPoison;
        this.isPoisoned = isPoisoned();
        this.damage = damage;
        this.effectiveRange = effectiveRange;
        this.arrowCount = 20;
        this.cost = cost;
        this.name = name;
        this.misfireRate = 0.0;
    }

    public double getMisfireRate() {
        return misfireRate;
    }

    //Changes the damage based on the poison state of the arrow.
    @Override
    public int getDamage() {
        if (!isPoisoned){
            damage+=15;
        }else {
            damage-=15;

        }
        return damage;
    }


    public void clean(){
        if (isPoisoned){
            isPoisoned=false;
            System.out.println("Arrow cleared for " +getName()+".");
        }else {
            System.out.println("Arrow is already clear for " + getName()+".");
        }
    }
    public void makePoisoned(){
        if (!isPoisoned){
            isPoisoned=true;
            System.out.println("Now  arrow is poisoned for " +getName()+".");
        }else {
            System.out.println("Arrow is already poisoned for " + getName()+".");
        }
    }



    public boolean isSupportPoison() {
        return supportPoison;
    }

    public void setSupportPoison(boolean supportPoison) {
        this.supportPoison = supportPoison;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    @Override
    public double getEffectiveRange() {
        return  effectiveRange;
    }

    public void setEffectiveRange(double effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public int getArrowCount() {
        return arrowCount;
    }


    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Decreases the arrow count by 1.
     * @return The updated arrow count after decreasing by 1.
     */
    public  int decreaseBullets(){
        return arrowCount--;
    }






}
