
public abstract   class Weapons {
    private   int cost;
    private String name;

    public int getDamage() {
        return damage;
    }

    public double getEffectiveRange() {
        return (int) effectiveRange;
    }

    private int damage;
    private double effectiveRange;
    private int bullet;



    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setEffectiveRange(int effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public Weapons(String name, int cost, int damage, double effectiveRange) {
        this.cost = cost;
        this.name = name;
        this.damage = damage;
        this.effectiveRange = effectiveRange;
    }

    public abstract String getInfo();
}


