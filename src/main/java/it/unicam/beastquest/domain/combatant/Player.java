package it.unicam.beastquest.domain.combatant;

public class Player extends AbstractCombatant{
    private int level;
    private int experience;
    private Inventory inventory;


    public Player(String name,int currentHp,int maxHp,int attackPower,int defense){
        super( name,currentHp,maxHp,attackPower,defense);
        this.level=1;
        this.experience=0;
        this.inventory=new Inventory();
    }

    public Player(String name,int currentHp,int maxHp,int attackPower,int defense,
                  int level,int experience, Inventory inventory){
        super(name,currentHp,maxHp,attackPower,defense);
        this.level=level;
        this.experience=experience;
        this.inventory=inventory;
    }




    public int getLevel(){return level;}

    public int getExperience(){return experience;}

    public boolean gainExperience(int xp){
      if(xp<=0){throw new IllegalArgumentException("xp negativi non validi:"+xp);}
      experience+=xp;
      boolean leveledUp=false;
        while (experience>=calculateXpThreshold()){
            levelUp();
            leveledUp=true;
        }
        return leveledUp;
    }

    private int calculateXpThreshold(){
        return getLevel()*100;
    }

   private void levelUp(){
         maxHp+=5;
         currentHp=maxHp;
         attackPower+=2;
         defense+=2;
         level+=1;
   }

   public Inventory getInventory(){
        return inventory;
   }


}
