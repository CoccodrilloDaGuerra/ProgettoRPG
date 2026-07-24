package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;

import java.util.Random;

public class FleeAction implements Action{
    private static final int FLEE_SUCCESS_CHANCE=50;
    private  final Random random;

    public FleeAction(){
        this.random=new Random();
    }
    @Override
    public TurnResult execute(Player player, Enemy enemy){

        boolean succeded= random.nextInt(100)<FLEE_SUCCESS_CHANCE;

        int damageToPlayer=0;

        if(!succeded){
            damageToPlayer=player.takeDamage(enemy.getAttackPower());
        }

        boolean playerDefeated=!player.isAlive();

        String message;

        if(succeded){
            message= player.getName()+" fugge con successo dal combattimento ";
        }else {
            message= player.getName()+" tenta di fuggie ma fallisce. "
                     + enemy.getName()+" attacca infliggendo "+ damageToPlayer+" danni ";
        }

        return TurnResult.fleeResult(message,succeded,damageToPlayer,playerDefeated);

    }
}
