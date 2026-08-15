package it.unicam.beastquest.domain.combatant;

/**
 *Rappresenta un'entità in grado di combattere (giocatore o nemico).
 * Definisce il contratto minimo che ogni combattente deve rispettare,
 * lasciando la logica di combattimento vera e propria (calcolo del danno,
 * scelta delle azoni) ai livelli applicativi superiori
 */
public interface Combatant {
    /**
     *
     * @return nome del combattente
     */
    String getName();

    /**
     *
     * @return gli HP attualmente posseduti
     */
    int getCurrentHp();

    /**
     *
     * @return gli Hp massimi del combattente
     */
    int getMaxHp();

    /**
     *
     * @return la potenza d'attacco del combattente
     */
    int getAttackPower();


    /**
     *
     * @return la difesa del combattente
     */
    int getDefense();

    /**
     * Applica danno al combattente, ridotto dalla sua difesa.
     *
     * @param amount danno grezzo da infliggere , prima della riduzione per difesa
     * @return il danno effettivamente  applicato
     * @throws IllegalArgumentException se amount è negativo
     */
    int takeDamage(int amount);


    /**
     *
     * @return {@code true} se gli HP correnti sono maggiori di zero
     */
    boolean isAlive();



    /**
     * Ripristina una quantità di HP, senza mai superare {@link #getMaxHp()}
     *
     * @param amount quantità di HP da recuperare
     * @throws IllegalArgumentException se {@code amount} è negativo
     */
    void heal(int amount);

}
