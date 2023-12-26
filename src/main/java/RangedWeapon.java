public  class RangedWeapon extends  Weapons{
    private String name;
    private int cost;
    private int damage;
    private int bulletCount;
    private double effectiveRange;
    private double misfireRate;

    public double getMisfireRate() {
        return misfireRate;
    }

    public RangedWeapon(String name, int cost, int damage, double effectiveRange) {
        super(name,cost,damage,effectiveRange);
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.bulletCount = 20;
        this.effectiveRange = effectiveRange;
        this.misfireRate= 0.3;
    }

    @Override
    public String getInfo() {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public double getEffectiveRange() {
        return effectiveRange;
    }

    public void setBulletCount(int bulletCount) {
        this.bulletCount = bulletCount;
    }

    public int decreaseBullets() {
        if (bulletCount > 0) {
            bulletCount--;
        }return bulletCount;
    }

    public boolean isInRange(double distance) {
        return distance <= effectiveRange;
    }
}
