package it.unicam.beastquest.domain.combatant;



public  abstract class AbstractCombatant implements Combatant {
  protected String name;
  protected int currentHp;
  protected int maxHp;
  protected int attackPower;
  protected int defense;

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
