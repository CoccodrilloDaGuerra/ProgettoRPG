package it.unicam.beastquest.persistence;

import com.google.gson.*;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.item.ItemType;
import it.unicam.beastquest.domain.item.Potion;
import it.unicam.beastquest.domain.item.TrophyItem;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {

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
