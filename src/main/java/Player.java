import java.util.List;
import java.util.ArrayList;
import java.util.Random;

enum PlayerLevel {
    masterExpert,
    beginnerAmateur,
}
public class Player {
    private String name;
    private int health;
    private int money;
    private boolean isImmortal;
    private double xPosition;
    private double yPosition;
    private  boolean isTerrorist;
    private  PlayerLevel playerLevel;
    private List<RangedWeapon> rangedWeapons;
    private List<MeleeWeapon> meleeWeapons;
    private boolean isMasterExpert;
    private Player targetPlayer;
    private List<Weapons> weapons;
    Pistol pistol;
    public Player(String name, boolean isTerrorist, boolean isMasterExpert) {
        this.name = name;
        this.money = isMasterExpert ? 1000 : 500;
        this.health = 100;
        this.isTerrorist = isTerrorist;
        this.isMasterExpert = isMasterExpert;
        this.isImmortal = false;
        this.xPosition = generatePosition(0,100);
        this.yPosition = generatePosition(0,50);
        this.rangedWeapons= new ArrayList<>();
        this.meleeWeapons= new ArrayList<>();
        this.weapons=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health =health;

    }
    public Player getTargetPlayer() {
        return targetPlayer;
    }


    public int getMoney() {
        return money;
    }

    public boolean isImmortal() {
        return isImmortal;
    }
    /**
     * Sets the player's immortal state.

     * @param immortal True if the player should become immortal, false otherwise.
     *  Only master expert players with enough money can become immortal.
     */
    public void setImmortal(boolean immortal) {
        if (isMasterExpert){
            if (money>=600){
                isImmortal = immortal;
                System.out.println(this.name + " is now immortal. ");
                this.money-=600;
            }else {
                System.out.println(this.name+ " cannot afford it. ");
            }
        }else {
            System.out.println(this.name + " cannot be immortal because is not master expert");
        }
    }

    public boolean isTerrorist() {
        return isTerrorist;
    }


    public void setPlayerLevel(PlayerLevel playerLevel) {
        this.playerLevel = playerLevel;
    }
    public String getTargetName() {
        return getTargetName();
    }

    public boolean isMasterExpert() {
        return isMasterExpert;
    }

    public void setMasterExpert(boolean masterExpert) {
        isMasterExpert = masterExpert;
    }

    public  static double RandomlyMisFareRate(){ // calculate mis fire rate randomly.
        Random random = new Random();
        double rate = random.nextDouble(0,1.0);
        return rate;}

    private int generatePosition(int min,int max) {
        Random random = new Random();
        //return min + (max - min) * random.nextInt();
        return min + random.nextInt(max - min + 1);
    }
    /**
     * Calculates the range between two positions.
     *
     * @param x1 The x-coordinate of the first position.
     * @param y1 The y-coordinate of the first position.
     * @param x2 The x-coordinate of the second position.
     * @param y2 The y-coordinate of the second position.
     * @return The Euclidean distance between the two positions.
     */
    public double calculateRange(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    /**
     * Shoots a target player using a specified weapon.
     * @param target       The target player to shoot.
     *
     */
    public void shoot(Player target , Weapons weapon, int targetXPosition, int targetYPosition) {
        double distance = calculateRange(xPosition, yPosition,targetXPosition, targetYPosition);
        if (target.isTerrorist == isTerrorist()) {
            System.out.println("Failed! Target player is on the same side ");
        }else if (target.health == 0) {
            System.out.println("Failed! enemy is already dead!");
        }
        else if (weapons.contains(weapon)) {
                 if (weapon instanceof RangedWeapon) {
                     // Check if the target is within the effective range of the weapon
                     if (weapon instanceof RangedWeapon && ((RangedWeapon) weapon).getEffectiveRange() >= distance){
                    if (RandomlyMisFareRate()>=((RangedWeapon) weapon).getMisfireRate()) { // ıdk  greater or smaller ı will handle it later.
                        int damage = weapon.getDamage();
                        System.out.println("Success! Pinpoint accuracy!");
                        System.out.println(this.name + " shoots at " + target.getName() + " with " + weapon.getName() + ".");
                        System.out.println("Info:  " + target.getName() + "'s health level decreased to " + target.decreasingHealth(damage) + ".");
                        System.out.println("Info: "+ this.name+ " has now "+ ((RangedWeapon) weapon).decreaseBullets() +" bullet(s) left in " + this.name + "'s magazine.");

                    }else {
                        System.out.println("Failed! weapon misfired.");
                    }

                        }else {
                     System.out.println(target.getName()+ " is out of range.");}
            }
            else if (weapon instanceof MeleeWeapon) { // Check if the weapon is a melee weapon
                     int damage = weapon.getDamage();
                if (distance==1) {
                    System.out.println("Success! Pinpoint accuracy!");
                    System.out.println(this.name + " shoots at " + target.getName() + " with " + weapon.getName() + ".");
                    System.out.println("Info:  " + target.getName() + "'s health level decreased to " + target.decreasingHealth(damage) + ".");
                }else {
                    System.out.println(target.getName()+ " is out of range.");
                }
            }
        }else {
            System.out.println("invalid weapon selection .");
        }
    }

    /**
     * Attaches a scope to the specified sniper gun.
     * @param sniperGun  The sniper gun to attach the scope to.
     */
    public void attachScope(SniperGun sniperGun) {
        if (this.isMasterExpert()) {
            if (this.weapons.contains(sniperGun)) {
                boolean isScopeAttached = sniperGun.isScopeAttached();
                if (isScopeAttached) {
                    System.out.println(sniperGun.getName() +" is already with scope");
                } else {
                    sniperGun.attachScope();
                }
            } else {
                System.out.println("You don't have the specified sniper rifle.");
            }
        } else {
            System.out.println("Only a master expert player can attach or detach the scope.");
        }
    }
    /**
     * Detach a scope to the specified sniper gun.
     * @param sniperGun  The sniper gun to detach  the scope to.
     */
    public void detachScope(SniperGun sniperGun) {
        if (this.isMasterExpert()) {
            if (this.weapons.contains(sniperGun)) {
                boolean isScopeAttached = sniperGun.isScopeAttached();
                if (!isScopeAttached) {
                    System.out.println(sniperGun.getName() +" is already without scope");
                } else {
                    sniperGun.detachScope();
                }
            } else {
                System.out.println("You don't have the specified sniper rifle.");
            }
        } else {
            System.out.println("Only a master expert player can attach or detach the scope.");
        }
    }
    /**
     * Moves the player to the specified coordinates.
     * @param newXPosition  The new X-coordinate of the player.
     * @param newYPosition  The new Y-coordinate of the player.
     */
    public void move(int newXPosition,int newYPosition){
        if (isInBoundaries(newXPosition,newYPosition)){
            this.xPosition = newXPosition;
            this.yPosition = newYPosition;
            System.out.println("New position of  player (x,y):  " + newXPosition + ","+newYPosition);

        }
        else {
            System.out.println("Invalid position! The new coordinates are out of bounds.");
        }
    }
    /**
     * Calculates the distance from the player to other players in the specified list.
     * @param players  The list of players to calculate the distance .
     */
    public void distanceToPlayers(List<Player> players) {
        for (Player player : players) {
            if (player != this) {
                double distance = calculateRange(xPosition, yPosition, player.xPosition, player.yPosition);
                System.out.println("Distance to " + player.getName() + ": " + distance);
            }
        }
    }
    private boolean isInBoundaries(int x, int y){
        int  minX = 0;
        int maxX = 100;
        int minY = 0;
        int maxY = 50;
        return (x >= minX && x <= maxX && y >= minY && y <= maxY);
    }



    /**
     * Sweeps on with the specified machine gun.
     * @param machineGun  The machine gun to sweep on.
     */
    public void sweepOn(MachineGun machineGun){
        if (isMasterExpert){
            if (this.weapons.contains(machineGun)){
                boolean isSweepOn= machineGun.isSweepActive();
                if (isSweepOn){
                    System.out.println(machineGun.getName()+ " is already sweep on .");
                }else {
                    machineGun.sweepOn();
                }
            }else {
                System.out.println("You don't have the specified machine gun.");
            }
        }else {
            System.out.println("Only a master expert player can activate or deactivate sweep for machine gun. ");
        }
    }
    /**
     * Sweeps off with the specified machine gun.

     * @param machineGun  The machine gun to sweep off.
     */
    public void sweepOf(MachineGun machineGun){
        if (isMasterExpert){
            if (this.weapons.contains(machineGun)){
                boolean isSweepOn= machineGun.isSweepActive();
                if (!isSweepOn){
                    System.out.println(machineGun.getName()+ " is already sweep of .");
                }else {
                    machineGun.sweepOf();
                }
            }else {
                System.out.println("You don't have the specified machine gun.");
            }
        }else {
            System.out.println("Only a master expert player can activate or deactivate sweep for machine gun. ");
        }
    }
    /**
     * Clears the poison status of the specified bow and arrow.
     * @param bowAndArrows  The bow and arrow to clear the poison status.
     */
    public  void ClearArrow(BowAndArrows bowAndArrows){
        if (isMasterExpert){
            if (this.weapons.contains(bowAndArrows)){
            boolean isItPoisoned= bowAndArrows.isPoisoned();
            if (!isItPoisoned){
                System.out.println("Arrow is already clear .");
            }else {
                bowAndArrows.clean();

            }
        }else {
                System.out.println("You don't have the specified bow and arrow.");
            }
        }else {
            System.out.println("Only a master expert player can change the poison status of the arrow.");
        }
    }
    /**
     * Poisons the specified bow and arrow.
     * @param bowAndArrows  The bow and arrow to poison.
     */
    public  void PoisonedArrow(BowAndArrows bowAndArrows){
        if (isMasterExpert){
            if (this.weapons.contains(bowAndArrows)){
                boolean isItPoisoned= bowAndArrows.isPoisoned();
                if (isItPoisoned){
                    System.out.println(" now arrow is already poisoned .");
                }else {
                    bowAndArrows.makePoisoned();
                }
            }else {
                System.out.println("You don't have the specified bow and arrow.");
            }
        }else {
            System.out.println("Only a master expert player can change the poison status of the arrow.");
        }
    }

    /**
     * Ignites the specified melee weapon.
     * @param meleeWeapon  The melee weapon to ignite.
     */
    public  void igniteMeleeWeapon(MeleeWeapon meleeWeapon){
        if (this.weapons.contains(meleeWeapon)){
            meleeWeapon.setFired(true);
            System.out.println(meleeWeapon.getName()+ " is ignited ");
        }else {
            System.out.println("Player doesn't have the specified melee weapon");
        }
    }
    /**
     * Douse the specified melee weapon.
     * @param meleeWeapon  The melee weapon to douse.
     */
    public  void douseMeleeWeapon(MeleeWeapon meleeWeapon){
        if (this.weapons.contains(meleeWeapon)){
            meleeWeapon.setFired(false);
            System.out.println(meleeWeapon.getName()+ " is doused ");
        }else {
            System.out.println("Player doesn't have the specified melee weapon");
        }
    }


    /**
     * drop the specified weapon from Weapons list.
     * @param weapon is specified weapon to drop.
     */
    public void dropWeapon(Weapons weapon){
        if (isMasterExpert){
            if (this.weapons.contains(weapon)){
                weapons.remove(weapon);
                System.out.println("Weapon " + weapon.getName() + " dropped successfully.");
            }else {
                System.out.println("you don't have " + weapon.getName()+".");
            }
        }else {
            System.out.println("only master expert players can drop weapon");
        }
    }

    /**
     * Exchanges weapons between the current player and a teammate.
     * @param teamMate  The teammate to exchange weapons with.
     * @param myWeapon   The weapon to be exchanged by the current player.
     * @param teamMatesWeapon   The weapon to be exchanged by the teammate.
     */
    public void exchangeWeapon(Player teamMate,Weapons myWeapon,Weapons teamMatesWeapon){
        if (this.isMasterExpert && teamMate.isMasterExpert){
            if (this.weapons.contains(myWeapon)&& teamMate.weapons.contains(teamMatesWeapon)){
                this.weapons.remove(myWeapon);
                teamMate.weapons.remove(teamMate);
                this.weapons.add(teamMatesWeapon);
                teamMate.weapons.add(myWeapon);
                System.out.println("Weapon " + myWeapon.getName() + " from " + this.getName() + " exchanged with " + teamMate.getName() + " from " + teamMate.getName() + ".");
            }else {
                System.out.println("One of the players does not have the specified weapon for the exchange.");
            }
        }else {
            System.out.println("Both players need to be master expert players for weapon exchange.");
        }
    }

    public void buyWeapon(Weapons weapon) {
        if (weapons.contains(weapon)){
            System.out.println(this.name+ " already have "+ weapon.getName()+".");
        } else if (weapon.getCost()>this.money) {
            System.out.println(this.name + " cannot afford it.");
        } else if (weapons.size()>getPlayerWeaponLimit()){
            System.out.println(this.name+" has reached the maximum limit of weapons  number that she/he can have.");
        }else {
            weapons.add(weapon);
            this.money-=weapon.getCost();
            System.out.println(this.name+" bought a "+ weapon.getName());
            System.out.println(this.name+ " now has "+ this.money+ " dollars!");
            }
        }

    private int getPlayerWeaponLimit() {
        if (isMasterExpert()) {
            return 5;
        } else {
            return 2;
        }
    }


    /**
     * Performs a money transaction between players.
     * @param borrower       The player borrowing money.
     * @param amountOfDept   The amount of money being borrowed.
     */
    public void loanMoney(Player borrower, int amountOfDept){ //Lending money to another player.
        if (borrower.isTerrorist){ // giving borrow money to enemy. it is not allowed.
            System.out.println("Failed! Come on! Too young to be a spy!");
        } else if (this.money < amountOfDept) { //situation that player doesn't have enough money to borrow.
            System.out.println("Failed! "+ this.name +" cannot afford it now!");
        }else {
            System.out.println("Success! " +  this.name +" is a perfect philanthropist!\n" +
                    "Info: "+ this.name +" has now " + (this.money- amountOfDept)+" dollars!\n"+
                    "Info: "+ borrower.name +" has now " + (borrower.money + amountOfDept) + " dollars!");}
    }
    /**
     * Restores the player's health to the maximum level by paying a hospital fee.
     * The player must have at least 500 dollars to afford the treatment.
     */
    public void takesCure(){
        if (this.money>= 500){
            health = 100;
            money -=500;
            System.out.println("Success! "+ this.name +" is now as fit as s(he) has never been before\n" +
                    "Info: "+ this.name+ "'s health level is now " + health+ ".\n" +
                    "Info: "+ this.name+" has now "+ this.money +"  dollars!");
        }
        else {System.out.println("Failed! "+ this.name +" cannot afford it now!");}
    }

    /**
     * Decreases the player's health by amount of damage.
     * @param damage The amount of damage to subtract from the player's health.
     * @return The player's updated health value after deducting the damage.
     */
    public int decreasingHealth(int damage){//health changing during game.
        if (!isImmortal){
            this.health -=damage ;
            if (this.health<0){
                this.health =0;}
        }   else {
            this.health =100;}
        return  health; }


    /**
     * Loads bullets into the player's pistol magazine.
     * The cost of loading bullets is deducted from the player's money.
     */
    public  void loadMagazine(){//loading bullets into the pistol's magazine.
        int cost = pistol.getBulletCost()*(20 -pistol.getMagazineCapacity()); // calculate the cost.player just pay money for 5 *(number of bullets fired).
        this.money -= cost; //decreasing cost from total money.
        System.out.println("Success! The real war begins now!\n"+
                "Info: "+ this.name +" has now 20 bullets in the magazine!\n"+
                "Info: "+this.name +" has now "+ this.money + " dollars!");
    }

}
