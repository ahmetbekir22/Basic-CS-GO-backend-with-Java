
public class MachineGun extends RangedWeapon {
    private  String name;
    private  boolean sweepActive;
    private int cost;
    private double effectiveRange;
    private int damage;
    private  int bulletMagazine =100;
    private double misfireRate;


    public int getBulletMagazine() {
        return bulletMagazine;
    }



    @Override
    public int getDamage() {
        return damage;
    }

    public double getMisfireRate() {
        return misfireRate;
    }

    /**
     * Constructs a MachineGun object.

     * @param name  the name of the machine gun
     * @param sweepActive  indicates if the sweep is active for the machine gun
     * @param cost  the cost of the machine gun
     * @param effectiveRange the effective range of the machine gun
     */
    public  MachineGun(String name,boolean sweepActive,int cost,int damage,double effectiveRange) {
        super(name, cost, damage, effectiveRange);
        this.cost = cost;
        this.effectiveRange = effectiveRange;
        this.name = name;
        this.sweepActive = sweepActive;
        this.misfireRate=0.1;
        this.damage = damage;

        //setMagazineCapacity(100); // hocaya sorucam .
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


    @Override
    public String getName() {
        return name;
    }
    public  int decreaseBullets(){
        int bulletNumber= bulletMagazine;
        if (getBulletMagazine()>0){
            if (isSweepActive()){
               bulletNumber -=10;
               return  bulletNumber;
            }else {
                  bulletNumber-=1;
                  return  bulletNumber;
            }
        }
        return  getBulletMagazine() ;
    }



    public void sweepOn(){
        if (!isSweepActive()){
            sweepActive= true;
            System.out.println("Sweep activated for "+ getName()+".");
        }
        else {
            System.out.println("Sweep is already activated for " + getName()+ ".");
        }
    }

    public void sweepOf(){
        if (isSweepActive()){
            sweepActive= false;
            System.out.println("Sweep deactivated for "+ getName()+".");
        }
        else {
            System.out.println("Sweep is already deactivated for " + getName()+ ".");
        }
    }


    public boolean isSweepActive() {
        return sweepActive;
    }

    public void setSweepActive(boolean sweepActive) {
        this.sweepActive = sweepActive;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
