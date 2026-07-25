package it.unicam.beastquest.ui.controllers;

import javafx.fxml.FXML;

public class MainMenuController {
@FXML
    private void handleNewGame(){
         //qui in futuro si andrà a creare un nuovo Player e passo all'hub
        System.out.println("Nuova Partita");

    }

    @FXML
    private void handleLoadGame(){
    //qui in futuro caricherò il salvataggio con GameSession
    System.out.println("Carica Partita");
    }
   @FXML
    private void handleExit(){
    System.exit(0);
   }

}
