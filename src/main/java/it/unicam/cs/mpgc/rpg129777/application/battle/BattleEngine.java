package it.unicam.cs.mpgc.rpg129777.application.battle;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Enemy;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;

/**
 * Orchestra lo svolgimento del turno di combattimento.
 *
 * Delega l'esecuzione vera e propria del turno all' {@link  Action} ricevuta,
 * e si occupa delle conseguenze di sistema che non competono alla singola
 * azione: assegnazione dei punti esperienza e consegna del loot quando il nemico
 * vine sconfitto. Questa separazione mantiene ogni {@link Action} concentrata
 * sulla propria responsabilità specifica (Single Responsibility Principle)
 */
public class BattleEngine {

    /**
     * Esegue il turno di combattimento e applica le conseguenze di
     * fine battaglia, se il nemico viene sconfitto.
     *
     * @param action l'azione scelta dal giocatore per questo turno
     * @param player il giocatore coinvolto nel turno
     * @param enemy il nemico coinvolto nel turno
     * @return il risultato del turno, da mostrare all'utente
     */
    public TurnResult executeTurn(Action action, Player player, Enemy enemy){
     TurnResult result= action.execute(player,enemy);

     if(result.isEnemyDefeated()){
         player.gainExperience(enemy.getXpReward());

         if (enemy.hasLoot()) {
             player.getInventory().addItem(enemy.getLoot());
         }

     }

        return result;
    }

}
