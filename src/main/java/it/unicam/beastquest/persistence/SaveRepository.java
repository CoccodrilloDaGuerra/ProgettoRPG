package it.unicam.beastquest.persistence;

import it.unicam.beastquest.domain.progress.SaveData;

public interface SaveRepository {

    void save(SaveData data);
    SaveData load();
    boolean saveExists();
    void deleteSave();
}
