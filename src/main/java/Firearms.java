public  abstract  class Firearms extends  RangedWeapon {
    private double misfireRate;

    @Override
    public int getDamage() {
        return damage;
    }

    private double fieldViewDistance;
    private  int damage;

    @Override
    public int getBulletCount() {
        return bulletCount;
    }

    private int bulletCount;

    public Firearms(String name, int cost, int damage, double effectiveRange) {
        super(name, cost, damage,effectiveRange);
        this.misfireRate = 0.3;
        this.fieldViewDistance = 0.0;
        this.bulletCount= getBulletCount();
    }
    public double getMisfireRate() {
        return misfireRate;
    }

    public void setMisfireRate(double misfireRate) {
        this.misfireRate = misfireRate;
    }
    public  int decreaseBulletAmount() {//decrease bullet amount after every successful shooting.
        return bulletCount --;
    }


    public double getFieldViewDistance() {
        return fieldViewDistance;
    }

    public void setFieldViewDistance(double fieldViewDistance) {
        this.fieldViewDistance = fieldViewDistance;
    }

    public abstract String getInfo();
}