package it.unicam.beastquest.domain.combatant;

import it.unicam.beastquest.domain.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
   private List<Item> items= new ArrayList<>();

   public void addItem(Item item){
      items.add(item);
   }

   public void removeItem(Item item){
       items.remove(item);
   }

   public List<Item> getItems(){
       return Collections.unmodifiableList(items);
   }

   public boolean isEmpty(){
       return items.isEmpty();
   }
}
