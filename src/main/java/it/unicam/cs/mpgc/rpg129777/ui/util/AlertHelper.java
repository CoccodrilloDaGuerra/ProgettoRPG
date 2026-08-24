package it.unicam.cs.mpgc.rpg129777.ui.util;

import it.unicam.cs.mpgc.rpg129777.domain.progress.StoryChapter;
import javafx.scene.control.Alert;

public class AlertHelper {

    private AlertHelper(){

    }
    public static void showChapterAlert(StoryChapter chapter){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(chapter.getTitle());
        alert.setHeaderText(chapter.getTitle());
        alert.setContentText(chapter.getText());

        alert.getDialogPane().setPrefSize(500,300);
        alert.getDialogPane().setMinSize(500,300);
        alert.setResizable(true);

        alert.showAndWait();
    }
}
