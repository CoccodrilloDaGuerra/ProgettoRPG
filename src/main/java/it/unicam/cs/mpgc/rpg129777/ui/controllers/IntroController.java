package it.unicam.cs.mpgc.rpg129777.ui.controllers;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;
import it.unicam.cs.mpgc.rpg129777.domain.item.Potion;
import it.unicam.cs.mpgc.rpg129777.domain.progress.GameProgress;
import it.unicam.cs.mpgc.rpg129777.domain.progress.StoryChapter;
import it.unicam.cs.mpgc.rpg129777.ui.navigation.SceneManager;
import it.unicam.cs.mpgc.rpg129777.ui.state.GameContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class IntroController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label storyLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       titleLabel.setText(StoryChapter.INTRO.getTitle());
       storyLabel.setText(StoryChapter.INTRO.getText());
    }

    @FXML
    private void handleContinua(){


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
                    player.getInventory().addItem(new Potion("Pozione curativa","Ripristina un pò di Hp",15));
                    GameProgress progress = new GameProgress(StoryChapter.INTRO);

                    GameContext.setCurrentPlayer(player);
                    GameContext.setCurrentProgress(progress);

                    SceneManager.switchTo("hub");
                }
        );
    }
}
