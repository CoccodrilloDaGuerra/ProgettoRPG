package it.unicam.beastquest.ui.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;
    private static  final String  STYLESHEET_PAHT= "/it/unicam/beastquest/ui/css/style.css";



    /**
     * Gestisce il caricamento e il cambio delle schermate (viste FXML)
     * dell'applicazione, centralizzando l'accesso allo {@link Stage} principale.
     *
     * Ogni vista è identificata da un nome semplice (ad esempio {@code "hub"}),
     * corrispondente a un file FXML nella cartella {@code ui/views} delle risorse.
     * Applica automaticamente il foglio di stile condiviso a ogni scena caricata.
     */
    private SceneManager(){

    }


    /**
     * Inizializza il gestore con lo stage principale dell'applicazione.
     * Va chiamato una sola volta, all'avvio.
     *
     * @param primaryStage lo stage principale fornito da JavaFX
     */
    public static void initialize(Stage primaryStage){
        stage=primaryStage;
    }


    /**
     * Carica la vista inidcata e la imposta come scena corrente.
     *
     *
     * @param viewName nome della vista corrispondente
     * al file {@code <viewName>.fxml} nella cartella delle viste
     *
     * @throws RuntimeException se la vista non può essere caricata
     */
    public static void switchTo(String viewName){
        try {
            String path= "/it/unicam/beastquest/ui/views/" + viewName + ".fxml";
            FXMLLoader loader= new FXMLLoader(SceneManager.class.getResource(path));
            Parent root= loader.load();

            Scene scene= new Scene(root,650,500);
            scene.getStylesheets().add(SceneManager.class.getResource(STYLESHEET_PAHT).toExternalForm());

            stage.setScene(scene);
        } catch (IOException e){
            throw new RuntimeException("Impossibile caricare la vista: "+viewName,e);
        }
    }
}
