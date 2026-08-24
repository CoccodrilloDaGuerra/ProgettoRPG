package it.unicam.cs.mpgc.rpg129777.domain.item;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Combatant;

/**
 * Rappresenta un oggetto che può essere usato su un {@link Combatant}
 * applicando un effetto (ad esempio una cura). Implementata dagli
 * {@link Item} che il giocatore può usare effettivamente in combattimento.
 */
public interface Usable {


    /**
     * Applica l'effetto dell'oggetto al bersaglio indicato
     *
     * @param target il combattente su cui applicare l'effetto
     * @return {@code true} se l'effetto è stato effettivamente applicato,
     * {@code false} se non ha avuto alcun impatto (ad esempio una
     * pozione curativa usata su un bersaglio già a HP pieni)
     */
    boolean use(Combatant target);
}


