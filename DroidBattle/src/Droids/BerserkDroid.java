package Droids;

import ConsoleColors.ConsoleColors;

public class BerserkDroid extends BaseDroid{
    public BerserkDroid(String name){
        super("Берсерк",name,200,40,45,10,10);
    }


    @Override
    protected boolean getDamage(int damage){
        var result = super.getDamage(damage);
        if (healthPoints <= DEFAULTHEALTHPOINTS/4 && healthPoints>0 && attackPoints == DEFAULTATTACKPOINTS){
            buffAttack(2.0);
            buffSpeed();
            buffCriticalDamageChance();
            buffDodgeChance();
            print(ConsoleColors.GREEN + "атака дроїда " + name + " збільшилася вдвічі"+
                    "\nшвидкість збільшилася на 15" +
                    "\nшанс критичного удару збільшився на 5"+
                    "\nшанс ухилення збільшився на 5" + ConsoleColors.RESET);
        }

        return result;
    }
}
