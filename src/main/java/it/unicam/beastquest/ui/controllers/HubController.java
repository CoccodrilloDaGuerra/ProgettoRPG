package it.unicam.beastquest.ui.controllers;

import it.unicam.beastquest.domain.progress.SaveData;
import it.unicam.beastquest.ui.navigation.SceneManager;
import it.unicam.beastquest.ui.state.GameContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
public class HubController implements Initializable {
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name= GameContext.getCurrentPlayer().getName();
        welcomeLabel.setText("Benvenuto, "+ name+ "!");
    }
    @FXML
    private void handleGoToBattle(){
        SceneManager.switchTo("battle");
    }
    @FXML
    private void handleSaveGame(){
        SaveData saveData= new SaveData(GameContext.getCurrentPlayer(),GameContext.getCurrentProgress());
        GameContext.getGameSession().saveGame(saveData);
    }

    @FXML
    private void handleBackToMenu(){
        SceneManager.switchTo("main-menu");
    }




}
