package it.unicam.cs.mpgc.rpg129777.application.battle;

public class TurnResult {

        private final String message;
        private final  int damageDealToEnemy;
        private final   int damageDealToPlayer;
        private final boolean enemyDefeated;
        private final boolean playerDefeated;
        private final boolean actionSucceded;

        private TurnResult(String message,int damageDealToEnemy,int damageDealToPlayer,
                           boolean enemyDefeated,boolean playerDefeated, boolean actionSucceded){

            this.message=message;
            this.damageDealToEnemy=damageDealToEnemy;
            this.damageDealToPlayer=damageDealToPlayer;
            this.enemyDefeated=enemyDefeated;
            this.playerDefeated=playerDefeated;
            this.actionSucceded=actionSucceded;
        }

        public static TurnResult attackResult(String message, int damageDealToEnemy, int damageDealToPlayer,
                                                                               boolean enemyDefeated, boolean playerDefeated){
            return new TurnResult(message,damageDealToEnemy,damageDealToPlayer,
                    enemyDefeated,playerDefeated,true);
        }

        public static TurnResult itemUseResult(String message, boolean actionSucceded,
                                                                                int  damageDealToPlayer, boolean playerDefeated){

            return new TurnResult(message,0,damageDealToPlayer,
                    false,playerDefeated,actionSucceded);
        }


        public static TurnResult fleeResult(String message, boolean actionSucceded,
                                                                             int damageDealToPlayer, boolean playerDefeated){
            return new TurnResult(message,0,damageDealToPlayer,
                    false, playerDefeated,actionSucceded);
        }

        public String getMessage(){
            return message;
        }
        public int getDamageDealToEnemy(){
            return damageDealToEnemy;
        }
        public int getDamageDealToPlayer(){
            return damageDealToPlayer;
        }
        public boolean isEnemyDefeated(){
            return enemyDefeated;
        }
        public boolean isPlayerDefeated(){
            return playerDefeated;
        }
        public boolean isActionSucceded(){
            return actionSucceded;
        }
}
