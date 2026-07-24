package it.unicam.beastquest.domain.combatant;

public interface Combatant {
    String getName();
    int getCurrentHp();
    int getMaxHp();
    int getAttackPower();
    int getDefense();
    int takeDamage(int amount);
    boolean isAlive();
    void heal(int amount);

}
