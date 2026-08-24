package it.unicam.cs.mpgc.rpg129777.domain.progress;

public class GameProgress {
    private StoryChapter currentChapter;

    public GameProgress(StoryChapter startingChapter){
        if(startingChapter==null){
            throw new IllegalStateException("capitolo non valido");
        }
        this.currentChapter=startingChapter;
    }

    public StoryChapter getCurrentChapter(){
        return currentChapter;
    }

  public StoryChapter advanceToNextChapter(){
        if(getCurrentChapter()==StoryChapter.ENDING){
            throw new IllegalArgumentException("IMPOSSIBILE AVANZARE, HAI RAGGIUNTO LA FINE");
        }
      currentChapter=StoryChapter.values()[currentChapter.ordinal()+1];
     return currentChapter;

  }


}
