package it.unicam.beastquest.ui.controllers;

import it.unicam.beastquest.application.battle.*;
import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.item.Potion;
import it.unicam.beastquest.ui.navigation.SceneManager;
import it.unicam.beastquest.ui.state.GameContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
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

    private Player player= GameContext.getCurrentPlayer();
    private Enemy enemy= GameContext.getCurrentEnemy();
   private final BattleEngine battleEngine= new BattleEngine();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Player player= GameContext.getCurrentPlayer();
        Enemy enemy= GameContext.getCurrentEnemy();

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
        }
    }

    @FXML
    private void handleFlee(){
        TurnResult result= battleEngine.executeTurn(new FleeAction(),player,enemy);
        messageLabel.setText(result.getMessage());
        updateUI();

        if(result.isActionSucceded() || result.isEnemyDefeated()){
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


}
