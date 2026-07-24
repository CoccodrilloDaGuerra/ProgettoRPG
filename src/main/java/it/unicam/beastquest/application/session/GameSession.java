package it.unicam.beastquest.application.session;

import it.unicam.beastquest.domain.progress.SaveData;
import it.unicam.beastquest.persistence.SaveRepository;

public class GameSession {

    private final  SaveRepository saveRepository;

    public GameSession(SaveRepository saveRepository){
        if(saveRepository==null){
            throw new IllegalArgumentException("save repository non valido");
        }
        this.saveRepository=saveRepository;

    }

    public void saveGame(SaveData data){
        saveRepository.save(data);
    }

    public SaveData loadGame(){
        return saveRepository.load();
    }

    public boolean hasSavedGame(){
        return saveRepository.saveExists();
    }
}
