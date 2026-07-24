package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;

public class AttackAction implements Action{
    @Override
    public TurnResult execute(Player player, Enemy enemy) {
        int damageOfPlayer =player.getAttackPower();
        int damageToEnemy=enemy.takeDamage(damageOfPlayer);

        int damageOfEnemy = enemy.getAttackPower();
        int damageToPlayer=0;

        if(enemy.isAlive()){
       damageToPlayer=player.takeDamage(damageOfEnemy);

        }

        boolean enemyDefeated= !enemy.isAlive();
        boolean playerDefeated= !player.isAlive();

       StringBuilder messageBuilder= new StringBuilder();
      messageBuilder.append(player.getName()).append(" attacca ").append(enemy.getName())
              .append(" infliggendo ").append(damageToEnemy).append(" danni ");

      if(!enemyDefeated){
          messageBuilder.append(" ").append(enemy.getName()).append(" contrattacca infliggendo ")
                  .append(damageToPlayer).append(" danni ");
      }

      String message= messageBuilder.toString();

      return TurnResult.attackResult(message,damageToEnemy,damageToPlayer,enemyDefeated,playerDefeated);

}
}
