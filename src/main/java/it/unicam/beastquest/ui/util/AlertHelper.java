package it.unicam.beastquest.ui.util;

import it.unicam.beastquest.domain.progress.StoryChapter;
import javafx.scene.control.Alert;

public class AlertHelper {

    private AlertHelper(){

    }
    public static void showChapterAlert(StoryChapter chapter){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(chapter.getTitle());
        alert.setHeaderText(chapter.getTitle());
        alert.setContentText(chapter.getText());
        alert.showAndWait();
    }
}
