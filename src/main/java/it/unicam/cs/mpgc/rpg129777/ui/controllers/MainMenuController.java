package it.unicam.cs.mpgc.rpg129777.ui.controllers;

import it.unicam.cs.mpgc.rpg129777.domain.progress.SaveData;
import it.unicam.cs.mpgc.rpg129777.ui.navigation.SceneManager;
import it.unicam.cs.mpgc.rpg129777.ui.state.GameContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
  @FXML
    private Button loadGameButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
     boolean hasSave=GameContext.getGameSession().hasSavedGame();
     loadGameButton.setVisible(hasSave);//nasconde visivamente il nodo
     loadGameButton.setManaged(hasSave);//dice al layout il VBox di non
        // riservare spazio per quel nodo, come se non esistesse

        deleteSaveButton.setVisible(hasSave);
        deleteSaveButton.setManaged(hasSave);
    }

    @FXML

    private void handleNewGame(){
      SceneManager.switchTo("intro");

    }

    @FXML
    private void handleLoadGame(){
    if(!GameContext.getGameSession().hasSavedGame()){
        return;
    }

        SaveData saveData= GameContext.getGameSession().loadGame();
        GameContext.setCurrentPlayer(saveData.getPlayer());
        GameContext.setCurrentProgress(saveData.getProgress());

        SceneManager.switchTo("hub");

    }


   @FXML
    private void handleExit(){
    System.exit(0);
   }

   @FXML
    private Button deleteSaveButton;
   @FXML
    private void handleDeleteSave(){
        Alert confirmation=new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Conferma Cancellazione");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Sei sicuro di voler cancellare il salvataggio? L'azione è irreversibile");

        Optional<ButtonType> result=confirmation.showAndWait();
        if(result.isPresent()&& result.get()==ButtonType.OK){
            GameContext.getGameSession().deleteSave();
            loadGameButton.setVisible(false);
            loadGameButton.setManaged(false);
            deleteSaveButton.setVisible(false);
            deleteSaveButton.setManaged(false);
        }
    }



}
