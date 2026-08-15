package it.unicam.beastquest.domain.item;

/**
 * Rappresenta un oggetto di gioco che può trovarsi nell'inventario
 * del giocatore. Le implementazioni concrete possono essere semplici
 * oggetti da collezione ({@link TrophyItem}) oppure oggetti utilizzabili
 * in combattimento, in tal caso implementano anche {@link Usable}
 */
public interface Item {

    /**
     *
     * @return il nome dell'oggeto
     */
    String getName();

    /**
     *
     * @return la descrizione testuale dell'oggetto
     */
    String getDescription();


    /**
     *
     * @return il tipo concreto dell'oggetto, usato anche per la
     * deserializzazione polimorfica in fase di caricamento di
     * un salvataggio (vedi {@code ItemDeserializer})
     */
    ItemType getType();
}
