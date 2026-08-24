package it.unicam.cs.mpgc.rpg129777.domain.combatant;


/**
 * Implementazione base di {@link Combatant}, condivisa da {@link Player}
 * ed {@link Enemy}. Centralizza la logica comune a ogni combattente
 * (calcolo e applicazione del danno, cura, controllo dello stato in vita),
 * lasciando alle sottoclassi solo l'aggiunta di attributi e comportamenti
 * specifici, senza mai alterare il comportamento dei metodi qui definiti
 * (Liskov Substitution Principle).
 */
public  abstract class AbstractCombatant implements Combatant {
  protected String name;
  protected int currentHp;
  protected int maxHp;
  protected int attackPower;
  protected int defense;


    /**
     *
     * @param name nome del combattente
     * @param currentHp HP correnti, compresi tra 0 e {@code maxHp}
     * @param maxHp HP massimi, deve essere positivo
     * @param attackPower potenza d'attacco, non negativa
     * @param defense difesa, non negativa
     * @throws IllegalArgumentException se uno dei parametri non rispetta i vincoli
     */
  protected AbstractCombatant(String name,int currentHp,int maxHp,int attackPower,int defense){
          if(name==null||name.isEmpty()|| maxHp<=0||attackPower<0||defense<0
          ||currentHp<0||currentHp>maxHp){
              throw new IllegalArgumentException("Dati non validi");
          }
          this.name=name;
          this.currentHp=currentHp;
          this.maxHp=maxHp;
          this.attackPower=attackPower;
          this.defense=defense;
  }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    /**
     * {@inheritDoc}
     * il danno netto è calcolato come {@code amount - defesne}, con un
     * minimo di zero: una difesa superiore all'attacco subito annulla
     * il danno, ma non può mai curare il combattente
     */
    @Override
    public int takeDamage(int amount) {
      if(amount<0){
          throw new IllegalArgumentException("danno negativo non valido:"+ amount);
      }
      int netdamage= Math.max(0,amount-defense);
      currentHp= Math.max(0,currentHp-netdamage);
      return netdamage;
    }

    @Override
    public boolean isAlive() {
        return currentHp > 0;
    }

    @Override
    public void heal(int amount) {
        if(amount<0){
            throw new IllegalArgumentException("cura non valida:"+ amount);
        }
        currentHp=Math.min(maxHp,currentHp+amount);
    }
}
