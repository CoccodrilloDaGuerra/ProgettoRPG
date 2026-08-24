package it.unicam.cs.mpgc.rpg129777.domain.item;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Combatant;

public class Potion implements Item,Usable{
    private String name;
    private String description;
    private int healAmount;
    private ItemType type;


    public Potion(String name,String description, int healAmount){
        if(name==null||description==null||name.isEmpty()||description.isEmpty()||healAmount<=0){
            throw new IllegalArgumentException("Parametri pozione non validi");
        }
        this.name=name;
        this.description=description;
        this.healAmount=healAmount;
        this.type=ItemType.POTION;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getDescription(){
    return description;
    }

    @Override
    public boolean use(Combatant target) {
        if(target.getCurrentHp()>=target.getMaxHp()){
            return false;
        }
        target.heal(healAmount);
        return true;
    }

    @Override
    public ItemType getType() {
        return type;
    }
}
