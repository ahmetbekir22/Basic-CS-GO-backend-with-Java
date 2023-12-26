public class SniperGun extends  RangedWeapon {
    private double misfireRate;
    private  String name;
    private  int cost;
    private int damage;

    private double effectiveRange;

    private  boolean scopeAttached;

    /**
     * Constructs a SniperGun object.
     * @param name  the name of the sniper gun
     * @param cost the cost of the sniper gun
     * @param effectiveRange the effective range of the sniper gun
     * @param scopeAttached  indicates if a scope is attached to the sniper gun
     */
    public SniperGun(String name, int cost, int damage, double effectiveRange,boolean scopeAttached) {
        super(name, cost, damage, effectiveRange);
        if (scopeAttached){
            misfireRate=0.45;}
        else {misfireRate = 0.01;}
        this.scopeAttached = scopeAttached;
        this.effectiveRange = effectiveRange;

        this.name=name;
        this.cost=cost;
        this.damage=20;
    }

    public double getMisfireForSniper() {
        return misfireRate;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public double getEffectiveRange() {
        return effectiveRange;
    }

    public void setEffectiveRange(int effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public boolean isScopeAttached() {
        return scopeAttached;
    }

    public double getMisfireRate() {
        return misfireRate;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public void attachScope() {
        if (!scopeAttached) {
            scopeAttached = true;
            System.out.println("Scope attached to " + getName() + ".");
        } else {
            System.out.println("Scope is already attached to " + getName() + ".");
        }
    }
    public void detachScope() {
        if (scopeAttached) {
            scopeAttached = false;
            System.out.println("Scope detached from " + getName() + ".");
        } else {
            System.out.println("Scope is already detached from " + getName() + ".");
        }
    }
    public void setScopeAttached(boolean scopeAttached) {
        this.scopeAttached = scopeAttached;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
