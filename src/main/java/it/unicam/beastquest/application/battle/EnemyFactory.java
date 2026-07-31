package it.unicam.beastquest.application.battle;

import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.item.Potion;
import it.unicam.beastquest.domain.item.TrophyItem;
import it.unicam.beastquest.domain.progress.GameProgress;
import it.unicam.beastquest.domain.progress.StoryChapter;

import java.util.Random;

public class EnemyFactory {

    private static final int LEVEL_THRESHOLD_FOR_BOSS=10;

    private final Random random;

    public EnemyFactory(){
        this.random=new Random();

    }

    public Enemy getRandomEnemy(){
        int index= random.nextInt(3);
       Item loot= random.nextInt(100)<40 ?  createHealingPotion(): null;
        return switch (index){
            case 0 -> new Enemy("Goblin",30,30,8,3,null,false,20);
            case 1 ->  new Enemy("Troll",45,45,10,5,null,false,35);
            default -> new Enemy("Scheletro",25,25,9,2,null,false,25);
        };
    }

    public Enemy getBoss(){
        Item bossLoot= new TrophyItem("Gemma del Boss", "Una prova della tua vittoria");
        return new Enemy("Torgor il Minotauro",150,150,20,10,bossLoot,true,200);
    }
    public boolean isBossAvailable(Player player, GameProgress progress){
        boolean reachedFinalChapter = progress.getCurrentChapter()== StoryChapter.FINAL_BOSS;
        boolean highEnoughLevel= player.getLevel()>=LEVEL_THRESHOLD_FOR_BOSS;

        return reachedFinalChapter || highEnoughLevel;
    }

    private Item createHealingPotion(){
        return new Potion("Pozione curativa","Ripristina un pò di Hp", 15);
    }
}
