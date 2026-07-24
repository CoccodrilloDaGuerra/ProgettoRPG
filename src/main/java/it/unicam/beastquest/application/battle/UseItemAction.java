package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.item.Potion;


public class UseItemAction implements Action {
    private final Potion item;

    public UseItemAction(Potion item){
        if(item==null){
            throw new IllegalArgumentException("item non valido");
        }
        this.item=item;
    }
    @Override
    public TurnResult execute(Player player, Enemy enemy){
        boolean succeded= item.use(player);

        int damageToPlayer=0;

        if(enemy.isAlive()){
            damageToPlayer=player.takeDamage(enemy.getAttackPower());
        }

        boolean playerDefeated= !player.isAlive();
        if(succeded){
            player.getInventory().removeItem(item);
        }

        StringBuilder messageBuilder= new StringBuilder();

        messageBuilder.append(player.getName()).append(" usa ").append(item.getName());

        if(succeded){
            messageBuilder.append(" e ne trae beneficio ");
        }else {
            messageBuilder.append(" , ma non ha effetto. ");
        }

        if(enemy.isAlive()){
            messageBuilder.append(" ").append(enemy.getName()).append(" attacca infliggendo ").
                    append(damageToPlayer).append(" danni ");
        }



        String message= messageBuilder.toString();
        return TurnResult.itemUseResult(message, succeded,damageToPlayer,playerDefeated);
    }

}
