package it.unicam.beastquest;

import it.unicam.beastquest.application.battle.AttackAction;
import it.unicam.beastquest.application.battle.BattleEngine;
import it.unicam.beastquest.application.battle.TurnResult;
import it.unicam.beastquest.domain.combatant.Enemy;
import it.unicam.beastquest.domain.combatant.Player;
import it.unicam.beastquest.domain.item.Item;
import it.unicam.beastquest.domain.item.Potion;
import it.unicam.beastquest.domain.progress.GameProgress;
import it.unicam.beastquest.domain.progress.SaveData;
import it.unicam.beastquest.domain.progress.StoryChapter;
import it.unicam.beastquest.persistence.JsonSaveRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Potion potion= new Potion("Cura","ripristina una parte degli hp",10);
        Player player= new Player("Eroe",50,50,10,5);
        Enemy enemy= new Enemy("Goblin",50,50,8,5,potion,false,104);

        player.getInventory().addItem(potion);


        BattleEngine battleEngine= new BattleEngine();
        AttackAction attackAction= new AttackAction();

        while (player.isAlive() && enemy.isAlive()){
            TurnResult result= battleEngine.executeTurn(attackAction,player,enemy);
            System.out.println(result.getMessage());
        }

        if(player.isAlive()){
            System.out.println(player.getName()+" ha vinto! livello: "+player.getLevel()
            +" ,esperienza "+ player.getExperience());
        }else {
            System.out.println(player.getName()+" è stato sconfitto. ");
        }

        GameProgress gameProgress= new GameProgress(StoryChapter.INTRO);
        SaveData saveData= new SaveData(player,gameProgress);

        JsonSaveRepository SaveRepository= new JsonSaveRepository();
        SaveRepository.save(saveData);
        SaveData loadedData =SaveRepository.load();


        System.out.println("Nome caricato: "+loadedData.getPlayer().getName());
        System.out.println("Livello ricaricato: "+loadedData.getPlayer().getLevel());
        System.out.println("Esperienza caricata: "+loadedData.getPlayer().getExperience());
        System.out.println("Capitolo ricaricato: "+loadedData.getProgress().getCurrentChapter());
        System.out.println("Numero oggetti in inventario ricaricato: "+loadedData.getPlayer().getInventory()
                .getItems().size());

        for(Item item :loadedData.getPlayer().getInventory().getItems()){
            System.out.println("Oggetto: "+item.getName()+" - Tipo "+item.getType());
        }

    }
}
