package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;

/**
 * Rappresenta un'azione che il giocatore può compiere durante un turno
 * di combattimento (ad esempio attaccare, usare un oggetto, fuggire).
 * Ogni implementazione incapsula la propria logica in modo indipendente,
 * permettendo di aggiungere nuove azioni senza modificare
 * {@link BattleEngine} (Open/Closed Principle).
 */
public interface Action {

    /**
     * Esegue l'azione, applicandone gli effetti su player e nemico.
     *
     * @param player il giocatore che compie l'azione
     * @param enemy il nemico coinvolto nel turno
     * @return il risultato del turno, con le informazioni da mostrare
     * all'utente e da usare per determinare la fine della battaglia
     */
    TurnResult execute(Player player, Enemy enemy);
}
