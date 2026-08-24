package it.unicam.cs.mpgc.rpg129777.persistence;

import it.unicam.cs.mpgc.rpg129777.domain.progress.SaveData;

/**
 * Astrae il meccanismo di salvataggio e caricamento della partita.
 * Il resto del codice dipende solo da questa interfaccia, non
 * dall'implementazione concreta, permettendo di sostituire il
 * sistema di persistenza (ad esempio JSON su file, o un database)
 * senza impattare il resto dell'applicazione.
 */
public interface SaveRepository {
    /**
     * Salva lo stato di gioco fornito, sovrascrivendo un eventuale
     * salvataggio precedente
     *
     * @param data lo stato di gioco da salvare
     */
    void save(SaveData data);


    /**
     * Carica l'ultimo stato di gioco salvato.
     *
     * @return lo stato di gioco caricato
     */
    SaveData load();

    /**
     * @return {@code true} se esiste un salvataggio disponibile da caricare
     */
    boolean saveExists();


    /**
     * Elimina il salvataggio esistente, se presente.
     */
    void deleteSave();
}
