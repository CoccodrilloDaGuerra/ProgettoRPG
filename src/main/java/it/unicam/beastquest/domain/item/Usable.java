package it.unicam.beastquest.domain.item;

import it.unicam.beastquest.domain.combatant.Combatant;

public interface Usable {
    boolean use(Combatant target);
}


