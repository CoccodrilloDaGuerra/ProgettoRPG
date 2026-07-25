package it.unicam.beastquest.ui.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    private SceneManager(){
        //classe di utilità non istanziabile
    }

    public static void initialize(Stage primaryStage){
        stage=primaryStage;
    }

    public static void switchTo(String viewName){
        try {
            String path= "/it/unicam/beastquest/ui/views/" + viewName + ".fxml";
            FXMLLoader loader= new FXMLLoader(SceneManager.class.getResource(path));
            Parent root= loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e){
            throw new RuntimeException("Impossibile caricare la vista: "+viewName,e);
        }
    }
}
