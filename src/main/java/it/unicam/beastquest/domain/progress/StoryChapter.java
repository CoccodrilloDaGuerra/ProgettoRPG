package it.unicam.beastquest.domain.progress;

public enum StoryChapter {
    INTRO("L'eredità di Mobius","Il Regno di Nidavelir piange la perdita di Morbius, il più valoroso dei cavlieri, "
            +"caduto nello scontro finale contro il malvagio mago Caius. "
             +"Ma la vittoria ha un prezzo: il potere di Caius, spezzato in frammenti, "
             +"si è disperso per le terre del regno, avvelenandole e  generando bestie mostruose. "
            +"Se le creature non vengono fermate presto arriveranno anche alla capitale e per il regno sarà la fine.  "
              +"Tocca a te raccogliere l'eredità di Mobius e ristabilire la pace."),

    MID_GAME("In viaggio nelle terre maledette","Le creature generate dai frammenti di Caius infestano i sentieri. "
    +" Le terre del regno sono irriconoscibili, anche il cielo è coperto da una coltre di nubi nere che bloccano il sole. "
    +"Il tuo cammino si fa arduo, ma la tua forza cresce ad ogni battaglia. "),

    FINAL_BOSS("Torgor il Minotauro","Hai percepito la sua presenza. Lo vedi palesarsi difronte a te, "
    +"un enorme minotauro dal pelo scuro con occhi rosso sangue e armato di una scure. "
    +"La prova finale ti attende. "),

    ENDING("Il primo passo verso la pace", "Hai sconfitto il minotauro e recuperato il frammento di Caius."
    +"La zona riprende vita e i mostri minori svniscono segno che l'influenza maligna è svanita. "
    +"Ma questo è solo l'inizio ci sono altre bestie simili a Torgor anzi forse pure più pericolose"
    +" che possiedono gli altri frammenti di Caius."+"Hai dimostrato di poter raccogliere l'eredità di Mobius. "+"Il tuo viaggio è appena cominciato,"
    +"sta a te ora sconfiggere le altre bestie e recuperare i restanti frammenti.");



    private final String title;
    private final String text;

    StoryChapter(String title,String text){
        this.title=title;
        this.text=text;
    }

    public  String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }

}
