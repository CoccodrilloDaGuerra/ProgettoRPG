package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;

public interface Action {
    TurnResult execute(Player player, Enemy enemy);
}
