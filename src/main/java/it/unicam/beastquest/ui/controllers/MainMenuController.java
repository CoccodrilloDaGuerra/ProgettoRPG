package it.unicam.beastquest.ui.controllers;

import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.progress.GameProgress;
import it.unicam.beastquest.domain.progress.SaveData;
import it.unicam.beastquest.domain.progress.StoryChapter;
import it.unicam.beastquest.ui.navigation.SceneManager;
import it.unicam.beastquest.ui.state.GameContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
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
    }

    @FXML

    private void handleNewGame(){
    TextInputDialog dialog= new TextInputDialog();
    dialog.setTitle("Nuovo eroe");
    dialog.setHeaderText("Crea il tuo personaggio");
    dialog.setContentText("Inserisci il nome: ");


    Optional<String> result= dialog.showAndWait();


    result.ifPresent(name -> {
                if (name.isBlank()) {
                    return;
                }
                Player player = new Player(name, 50, 50, 10, 5);
                GameProgress progress = new GameProgress(StoryChapter.INTRO);

                GameContext.setCurrentPlayer(player);
                GameContext.setCurrentProgress(progress);

                SceneManager.switchTo("hub");
            }
    );

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

}
