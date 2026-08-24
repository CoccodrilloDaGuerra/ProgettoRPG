package it.unicam.cs.mpgc.rpg129777.ui.state;


import it.unicam.cs.mpgc.rpg129777.application.session.GameSession;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Enemy;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;
import it.unicam.cs.mpgc.rpg129777.domain.progress.GameProgress;
import it.unicam.cs.mpgc.rpg129777.persistence.JsonSaveRepository;

public class GameContext {
    private static Player currentPlayer;
    private static GameProgress currentProgress;
    private static Enemy currentEnemy;
    private static  final GameSession gameSession= new GameSession(new JsonSaveRepository());

    /**
     * Mantiene lo stato condiviso della sessione di gioco corrente
     * (giocatore attivo, progresso narrativo, nemico corrente, accesso al
     *  sistema di salvataggio), accessibile da qualsiasi controller JavaFX.
     *
     * Ogni cambio di schermata istanzia un nuovo controller senza continuità
     * automatica di dati; questa classe risolve il problema centralizzando
     * lo stato in campi statici, condivisi indipendentemente dal controller
     * attivo in un dato momento.
     *
     * <b>Nota di design</b>: l'uso di campi statici è un compromesso
     * adatta alla portata del progetto, non la soluzione più aderente ai principi
     * SOLID in astratto.
     */
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

    public static Enemy getCurrentEnemy(){
        return currentEnemy;
    }


    public static void setCurrentEnemy(Enemy enemy){
        currentEnemy=enemy;
    }


    public static void setCurrentProgress(GameProgress progress){
        currentProgress=progress;
    }

    /**
     *
     * @return l'istanza condivisa di {@link GameSession}, usata
     * per salvare e caricare la partita
     */
    public  static GameSession getGameSession(){
        return gameSession;
    }

}
