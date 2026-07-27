package it.unicam.beastquest.ui.state;


import it.unicam.beastquest.application.session.GameSession;
import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.progress.GameProgress;
import it.unicam.beastquest.persistence.JsonSaveRepository;

public class GameContext {
    private static Player currentPlayer;
    private static GameProgress currentProgress;
    private static  final GameSession gameSession= new GameSession(new JsonSaveRepository());


    private GameContext(){
      //classe di utilità non instanziabile
    }

    public static Player getCurrentPlayer(){
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player player){
        currentPlayer=player;
    }

    public static GameProgress getCurrentProgress(){
        return currentProgress;
    }

    public static void setCurrentProgress(GameProgress progress){
        currentProgress=progress;
    }

    public  static GameSession getGameSession(){
        return gameSession;
    }

}
