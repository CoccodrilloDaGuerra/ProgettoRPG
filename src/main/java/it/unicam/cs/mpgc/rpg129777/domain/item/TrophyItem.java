package it.unicam.cs.mpgc.rpg129777.domain.item;

public class TrophyItem implements Item{

    private String name;
    private String description;
    private ItemType type;

    public TrophyItem(String name, String description){

        if(name==null||description==null||name.isEmpty()||description.isEmpty()){
            throw new IllegalArgumentException("Parametri TrophyItem non validi");
        }
        this.name=name;
        this.description=description;
        this.type=ItemType.TROPHY;
    }

   @Override
   public String getName(){
        return name;
   }

   @Override
   public String getDescription(){
        return description;
   }

    @Override
    public ItemType getType() {
        return type;
    }
}
