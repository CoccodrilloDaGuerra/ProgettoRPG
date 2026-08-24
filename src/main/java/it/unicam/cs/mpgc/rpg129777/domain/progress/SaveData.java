package it.unicam.cs.mpgc.rpg129777.domain.progress;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;

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
