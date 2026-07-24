package it.unicam.beastquest.domain.progress;

import it.unicam.beastquest.domain.combatant.Player;

public class SaveData {

    private Player player;
    private GameProgress progress;

    public SaveData(Player player,GameProgress progress){
        if(player==null||progress==null){
            throw new IllegalArgumentException("Player o progressi non validi");
        }
        this.player=player;
        this.progress=progress;
    }
    public Player getPlayer(){
        return player;
    }

    public GameProgress getProgress(){
        return progress;
    }

}
