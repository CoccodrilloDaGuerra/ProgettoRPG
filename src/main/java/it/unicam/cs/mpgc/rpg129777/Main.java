package it.unicam.cs.mpgc.rpg129777;


import it.unicam.cs.mpgc.rpg129777.ui.navigation.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        SceneManager.initialize(primaryStage);
        SceneManager.switchTo("main-menu");

        primaryStage.setTitle("Beast Quest");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
