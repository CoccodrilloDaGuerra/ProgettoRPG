package it.unicam.cs.mpgc.rpg129777.ui.controllers;

import it.unicam.cs.mpgc.rpg129777.application.battle.*;
import it.unicam.cs.mpgc.rpg129777.application.battle.*;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Enemy;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;
import it.unicam.cs.mpgc.rpg129777.domain.item.Item;
import it.unicam.cs.mpgc.rpg129777.domain.item.Potion;
import it.unicam.cs.mpgc.rpg129777.domain.progress.StoryChapter;
import it.unicam.cs.mpgc.rpg129777.ui.navigation.SceneManager;
import it.unicam.cs.mpgc.rpg129777.ui.state.GameContext;
import it.unicam.cs.mpgc.rpg129777.ui.util.AlertHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import it.unicam.cs.mpgc.rpg129777.domain.progress.GameProgress;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;



public class BattleController implements Initializable {

    @FXML private Label playerNameLabel;
    @FXML private ProgressBar playerHpBar;
    @FXML private Label playerHpLabel;


    @FXML private Label enemyNameLabel;
    @FXML private ProgressBar enemyHpBar;
    @FXML private Label enemyHpLabel;

    @FXML private Label messageLabel;


    @FXML private Button attackButton;
    @FXML private Button useItemButton;
    @FXML private Button fleeButton;
    @FXML private Button returnToHubButton;

    private Player player;
    private Enemy enemy;
   private final BattleEngine battleEngine= new BattleEngine();

    @Override
    public void initialize(URL location, ResourceBundle resources){
         player= GameContext.getCurrentPlayer();
        enemy= GameContext.getCurrentEnemy();

        playerNameLabel.setText(player.getName());
        enemyNameLabel.setText(enemy.getName());


        updateUI();

    }


    private void updateUI(){
      playerHpBar.setProgress(player.getCurrentHp()/(double)player.getMaxHp());
      playerHpLabel.setText("HP: "+player.getCurrentHp()+ "/" + player.getMaxHp());

        enemyHpBar.setProgress(enemy.getCurrentHp()/(double)enemy.getMaxHp());
        enemyHpLabel.setText("HP: "+enemy.getCurrentHp()+ "/" + enemy.getMaxHp());


    }

    private void endBattle(TurnResult result){

        attackButton.setDisable(true);
        useItemButton.setDisable(true);
        fleeButton.setDisable(true);

        if(result.isPlayerDefeated()){
            messageLabel.setText(messageLabel.getText()
            +"\n\nSei stato sconfitto, ma riesci a fuggire e a tornare al villaggio per riprenderti. ");

        }else if(result.isEnemyDefeated()&& enemy.isBoss()){
            messageLabel.setText(messageLabel.getText() +"\n\nHai sconfitto "+ enemy.getName()+"! Hai ottenuto un frammento" +
                    "del potere di Caius");
        } else if (result.isEnemyDefeated()) {
            messageLabel.setText(messageLabel.getText()
                    +"\n\nHai vinto lo scontro");
        }


        returnToHubButton.setVisible(true);
        returnToHubButton.setManaged(true);

    }
    @FXML
    private void handleAttack(){
        TurnResult result= battleEngine.executeTurn(new AttackAction(),player,enemy);
        messageLabel.setText(result.getMessage());
        updateUI();

        if(result.isEnemyDefeated() || result.isPlayerDefeated()){
            endBattle(result);
            checkChapterProgress();
        }
    }


    @FXML
    private void handleUseItem(){
        Potion potion= findFirstPotion();
        if(potion==null){
            messageLabel.setText("Non hai pozioni da usare");
            return;
        }

        TurnResult result= battleEngine.executeTurn(new UseItemAction(potion),player,enemy);

        messageLabel.setText(result.getMessage());
        updateUI();

        if(result.isEnemyDefeated() || result.isPlayerDefeated()){
            endBattle(result);
            checkChapterProgress();
        }

    }

    @FXML
    private void handleFlee(){
        TurnResult result= battleEngine.executeTurn(new FleeAction(),player,enemy);
        messageLabel.setText(result.getMessage());
        updateUI();

        if(result.isActionSucceded() || result.isPlayerDefeated()){
            endBattle(result);
        }
    }

    @FXML
    private void handleReturnToHub(){
        SceneManager.switchTo("hub");
    }

    private Potion findFirstPotion(){
        for(Item item:  player.getInventory().getItems()){
            if(item instanceof Potion potion){
                return potion;
            }
        }
        return null;
    }

    private void checkChapterProgress(){
        GameProgress progress=GameContext.getCurrentProgress();
        boolean isWin= !enemy.isAlive() && !enemy.isBoss();

        if(isWin && progress.getCurrentChapter()== StoryChapter.INTRO){
            progress.advanceToNextChapter();
            AlertHelper.showChapterAlert(progress.getCurrentChapter());
        }
    }




}
