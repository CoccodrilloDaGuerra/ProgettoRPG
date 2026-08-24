package it.unicam.cs.mpgc.rpg129777.ui.controllers;

import it.unicam.cs.mpgc.rpg129777.application.battle.EnemyFactory;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Enemy;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;
import it.unicam.cs.mpgc.rpg129777.domain.progress.GameProgress;
import it.unicam.cs.mpgc.rpg129777.domain.progress.SaveData;
import it.unicam.cs.mpgc.rpg129777.domain.progress.StoryChapter;
import it.unicam.cs.mpgc.rpg129777.ui.navigation.SceneManager;
import it.unicam.cs.mpgc.rpg129777.ui.state.GameContext;
import it.unicam.cs.mpgc.rpg129777.ui.util.AlertHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




public class HubController implements Initializable {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label playerHpLabel;

    @FXML
    private Button challengeBossButton;
    @FXML
    private Label playerLevelLabel;

    private final EnemyFactory enemyFactory= new EnemyFactory();
    private Player player= GameContext.getCurrentPlayer();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       applyRestRecovery();


        String name= GameContext.getCurrentPlayer().getName();
        welcomeLabel.setText("Ciao, "+player.getName()+ "!");
        playerHpLabel.setText("HP: "+ player.getCurrentHp() + "/"+ player.getMaxHp());
        playerLevelLabel.setText("Livello: "+player.getLevel());

        checkChapterProgress();


        boolean bossAvailable= enemyFactory.isBossAvailable(player, GameContext.getCurrentProgress());

        challengeBossButton.setVisible(bossAvailable);
        challengeBossButton.setManaged(bossAvailable);
    }



    @FXML
    private void handleFightCommonEnemy(){
        Enemy enemy= enemyFactory.getRandomEnemy();
        GameContext.setCurrentEnemy(enemy);
        SceneManager.switchTo("battle");
    }

    @FXML
    private void handleFightBoss(){
        Enemy boss= enemyFactory.getBoss();
        GameContext.setCurrentEnemy(boss);
        SceneManager.switchTo("battle");
    }


    @FXML
    private void handleSaveGame(){
        SaveData saveData= new SaveData(GameContext.getCurrentPlayer(),GameContext.getCurrentProgress());
        GameContext.getGameSession().saveGame(saveData);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Partita Salvata");
        alert.setTitle(null);
        alert.setContentText("La tua avventura è stata salvata con successo.");
        alert.showAndWait();
    }



    @FXML
    private void handleBackToMenu(){
        SceneManager.switchTo("main-menu");
    }

private void checkChapterProgress(){
    GameProgress progress= GameContext.getCurrentProgress();
    boolean bossAvailable= enemyFactory.isBossAvailable(GameContext.getCurrentPlayer(),progress);

    if(bossAvailable && progress.getCurrentChapter()== StoryChapter.MID_GAME){
        progress.advanceToNextChapter();
        AlertHelper.showChapterAlert(progress.getCurrentChapter());

    }
}




private static final double REST_RECOVERY_PERCENTAGE=0.3;


    private void applyRestRecovery(){
        int missingHp=player.getMaxHp()- player.getCurrentHp();
        int recoveredAmount= (int) (missingHp * REST_RECOVERY_PERCENTAGE);

        if(recoveredAmount>0){
            player.heal(recoveredAmount);
        }
    }


}
