package it.unicam.cs.mpgc.rpg129777.application.battle;

import it.unicam.cs.mpgc.rpg129777.domain.combatant.Enemy;
import it.unicam.cs.mpgc.rpg129777.domain.combatant.Player;
import it.unicam.cs.mpgc.rpg129777.domain.item.Item;
import it.unicam.cs.mpgc.rpg129777.domain.item.Potion;
import it.unicam.cs.mpgc.rpg129777.domain.item.TrophyItem;
import it.unicam.cs.mpgc.rpg129777.domain.progress.GameProgress;
import it.unicam.cs.mpgc.rpg129777.domain.progress.StoryChapter;

import java.util.Random;

/**
 * Genera le istanze di {@link Enemy} incontrate durante il gioco.
 *<p>
 * Ogni chiamata a {@link #getRandomEnemy()} o {@link #getBoss()} produce
 * una nuova istanza fresca, con HP pieni, evitando di riutilizzare oggetti
 * già danneggiati da combattimenti precedenti
 */
public class EnemyFactory {

    private static final int LEVEL_THRESHOLD_FOR_BOSS=10;

    private final Random random;

    public EnemyFactory(){
        this.random=new Random();

    }

    /**
     *
     * @return un nemico comune scelto casualmente tra quelli disponibili
     */
    public Enemy getRandomEnemy(){
        int index= random.nextInt(3);
       Item loot= random.nextInt(100)<40 ?  createHealingPotion(): null;
        return switch (index){
            case 0 -> new Enemy("Goblin",30,30,8,3,null,false,20);
            case 1 ->  new Enemy("Troll",45,45,10,5,null,false,35);
            default -> new Enemy("Scheletro",25,25,9,2,null,false,25);
        };
    }


    /**
     *
     * @return una nuova istanza del Boss del gioco
     */
    public Enemy getBoss(){
        Item bossLoot= new TrophyItem("Gemma del Boss", "Una prova della tua vittoria");
        return new Enemy("Torgor il Minotauro",150,150,20,10,bossLoot,true,200);
    }


    /**
     * Determina se il Boos è affrontabile dal giocatore, in base a
     * una doppia condizione: aver raggiunto il capitolo narrativo finale,
     * oppure aver raggiunto un livello sufficentemente alto.
     *
     * @param player il giocatore di cui verificare il livello
     * @param progress il progresso narrativo corrente
     * @return {@code true} se almeno una delle due condizioni è soddisfatta
     */
    public boolean isBossAvailable(Player player, GameProgress progress){
        boolean reachedFinalChapter = progress.getCurrentChapter()== StoryChapter.FINAL_BOSS;
        boolean highEnoughLevel= player.getLevel()>=LEVEL_THRESHOLD_FOR_BOSS;

        return reachedFinalChapter || highEnoughLevel;
    }

    private Item createHealingPotion(){
        return new Potion("Pozione curativa","Ripristina un pò di Hp", 15);
    }
}
