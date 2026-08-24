package it.unicam.cs.mpgc.rpg129777.domain.combatant;

import it.unicam.cs.mpgc.rpg129777.domain.item.Item;

public class Enemy extends AbstractCombatant {
    private Item loot;
    private boolean isBoss;
    private int xpReward;
    public Enemy(String name,int currentHp,int maxHp,int attackPower,int defense,
                 Item loot, boolean isBoss,int xpReward){

        super( name,currentHp,maxHp,attackPower,defense);
        if(xpReward<=0){
            throw new IllegalArgumentException("Dati non validi");
        }
        this.loot=loot;
        this.isBoss=isBoss;
        this.xpReward=xpReward;


    }

    public Item getLoot(){
        return loot;
    }
    public boolean hasLoot(){
        return loot!=null;
    }
    public boolean isBoss(){
        return isBoss;
    }
    public int getXpReward(){
        return xpReward;
    }



}
