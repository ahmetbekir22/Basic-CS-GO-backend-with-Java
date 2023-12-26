import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player ahmet = new Player("ahmet",false,true);
        Player bekir = new Player("bekir",true,true);
        Player eren = new Player("eren",false,true);
        Player Lale = new Player("Lale",false,false);
        players.add(ahmet);
        players.add(bekir);
        players.add(eren);
        players.add(Lale);

        MeleeWeapon meleeWeapon = new MeleeWeapon("Melee Weapon", 23,20,true,1);
        RangedWeapon rangedWeapon= new RangedWeapon(" ranged gun ",75,20,190);
        BowAndArrows bowAndArrows= new BowAndArrows("BAA",34,112,20,true);
        MachineGun machineGun = new MachineGun("machine gun ",true,67,20,128);
        SniperGun sniperGun = new SniperGun("Sniper rifle ",45,20,470,true);

        System.out.println("operation #1 : eren buy a machine gun");
        eren.buyWeapon(machineGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #2 : bekir buy a sniper gun");
        bekir.buyWeapon(sniperGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #3 : ahmet buy a sniper gun");
        ahmet.buyWeapon(sniperGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #4 : ahmet shoots  at bekir with sniper gun");
        ahmet.shoot(bekir,sniperGun,10,71);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #5: ahmet attach the scope to sniper gun");
        ahmet.attachScope(sniperGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #6 : ahmet shoots  at bekir with sniper gun");
        ahmet.shoot(bekir,sniperGun,16,21);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #5: ahmet detach the scope from sniper gun");
        ahmet.detachScope(sniperGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #8 : ahmet shoots  at bekir with sniper gun");
        ahmet.shoot(bekir,sniperGun,8,35);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #9: ahmet drop the sniper gun sniper gun");
        ahmet.dropWeapon(sniperGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");


        System.out.println("operation #10 : ahmet buy a bow and arrow");
        ahmet.buyWeapon(bowAndArrows);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #11 : ahmet shoots  at bekir with bow and arrow");
        ahmet.shoot(bekir,bowAndArrows,15,52);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #12 : bekir takes cure. ");
        bekir.takesCure();
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #13 : ahmet make arrow poisoned. ");
        ahmet.PoisonedArrow(bowAndArrows);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #14 : ahmet shoots  at bekir with bow and arrow");
        ahmet.shoot(bekir,bowAndArrows,36,54);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #15 : ahmet make arrow clear. ");
        ahmet.ClearArrow(bowAndArrows);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #16 : ahmet shoots  at bekir with bow and arrow");
        ahmet.shoot(bekir,bowAndArrows,11,33);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");


        System.out.println("operation #17 : ahmet buy a melee weapon");
        ahmet.buyWeapon(meleeWeapon);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #18 : ahmet shoots  at bekir with melee weapon");
        ahmet.shoot(eren,meleeWeapon,56,20);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #19: ahmet ignite the melee weapon with fire.");
        ahmet.igniteMeleeWeapon(meleeWeapon);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #20 : ahmet shoots  at bekir with melee weapon");
        ahmet.shoot(eren,meleeWeapon,6,0);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #21: ahmet douse the melee weapon.");
        ahmet.douseMeleeWeapon(meleeWeapon);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");


        System.out.println("operation #22 : ahmet buy a machine gun");
        ahmet.buyWeapon(machineGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");


        System.out.println("operation #23 : ahmet turned off the sweep");
        ahmet.sweepOf(machineGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #24 : ahmet shoots at bekir with machine gun.");
        ahmet.shoot(bekir,machineGun,31,46);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #25 : ahmet and eren exchange weapons");
        ahmet.exchangeWeapon(eren,meleeWeapon,machineGun);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #26 : ahmet move to new position.");
        ahmet.move(12,24);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");

        System.out.println("operation #27 : ahmet show distance to other players. ");
        ahmet.distanceToPlayers(players);


    }
}
