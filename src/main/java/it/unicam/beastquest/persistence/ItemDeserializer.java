package it.unicam.beastquest.persistence;

import com.google.gson.*;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.item.ItemType;
import it.unicam.beastquest.domain.item.Potion;
import it.unicam.beastquest.domain.item.TrophyItem;

import java.lang.reflect.Type;


/**
 * Deserializzatore Gson custom per l'interfaccia {@link Item}.
 * <p>
 * Gson, di base, non è in grado di determinare quale classe concreta
 * istanziare durante la deserializzazione di un'interfaccia con più
 * implementazioni. Questa classe risolve il problema leggendo il campo
 * {@code type} (di tipo {@link ItemType}), presente in ogni implementazione
 * concreta di {@link Item}, e delegando la deserializzazione alla classe
 * corretta ({@link Potion} o {@link TrophyItem}).
 * <p>
 * Va registrato nella configurazione di {@code Gson} tramite
 * {@code GsonBuilder.registerTypeAdapter(Item.class, new ItemDeserializer())}.
 */
public class ItemDeserializer implements JsonDeserializer<Item> {

    /**
     *Determina la classe concreta da instanziare in base al campo
     * {@code type} presente nel JSON, e  delega a Gson la
     * deserializzazione dei restanti campi.
     *
     * @throws JsonParseException se il valore di {@code type} non
     * corrisponde  a nessun {@link ItemType} conosciuto
     */
    @Override
    public Item deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject= jsonElement.getAsJsonObject();

        String typeString= jsonObject.get("type").getAsString();

        ItemType type= ItemType.valueOf(typeString);


        switch (type){
            case POTION -> {
                return jsonDeserializationContext.deserialize(jsonObject, Potion.class);
            }
            case TROPHY -> {
                return jsonDeserializationContext.deserialize(jsonObject, TrophyItem.class);
            }
            default -> throw new JsonParseException("Tipo di Item  sconosciuto: "+ typeString);
        }
    }
}
