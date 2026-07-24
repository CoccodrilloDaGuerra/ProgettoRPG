package it.unicam.beastquest.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.progress.SaveData;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSaveRepository implements SaveRepository{

    private static final String SAVE_FILE_PATH = "saves/savegame.json";

    private final Gson gson;

    public JsonSaveRepository(){
        this.gson=new GsonBuilder()
                .registerTypeAdapter(Item.class, new ItemDeserializer())
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void save(SaveData data) {
        try {
            Path path= Path.of(SAVE_FILE_PATH);

            Files.createDirectories(path.getParent());
            try(FileWriter writer= new FileWriter(path.toFile())){
                gson.toJson(data,writer);
            }

        } catch (IOException e){
            throw new RuntimeException("Errore durante  il salvataggio della partita", e);
        }
    }


    @Override
    public SaveData load() {
        try (FileReader reader= new FileReader(SAVE_FILE_PATH)){
                  return gson.fromJson(reader, SaveData.class);
        }catch (IOException e){
            throw new RuntimeException("Errore durante il caricamento della partita",e);
        }
    }

    @Override
    public boolean saveExists() {
        return Files.exists(Path.of(SAVE_FILE_PATH));
    }
}
