package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;


public class BattleEngine {

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
