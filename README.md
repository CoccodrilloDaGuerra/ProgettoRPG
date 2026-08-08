# Beast Quest
Demo di un RPG a turni sviluppato in Java, con interfaccia grafica JavaFx, progettata seguendo i principi SOLID e le pratiche di Clean Code.

## Descrizione
Beast Quest è un piccolo gioco di ruolo, in cui il giocatore impersona un eroe che deve affrontare mostri comuni e un boss finale,
in un regno colpito dagli effetti del potere del un mago malvagio Caius, che ha generato mostri che terrorizzano il regno.
Il progetto è stato sviluppato come esercizio di progettazione software, con attenzione alla separazione dei layer e all'estendibilità futura.

## Funzionalità
- Combattimento a turni (Attacca/ Usa Oggetto / Fugggi)
- Sistema con punti esperienza e level up
- Inventario con oggetti utilizzabili (pozioni per ora) e da collezione (trofei)
- Avanzamento narrativo a capitoli, con testo descrittivo per ciascuno di essi
- Il boss è sbloccabile al raggiungimento di un certo livello o del capitolo finale
- Il salvataggio e caricamento della partita è in formato JSON
- L'interfaccia grafica fatta con JavaFx con tema visivo dedicato

## Stack tecnologico
- **Java 25**
- **Gradle (Kotlin DSL)** come build system
- **JavaFX 25** per l'interfaccia grafica
- **Gson** per la serializzazione e deserializzazione JSON

## Come avviare il progetto
Prerequisiti: JDK 25 installato

## Istruzioni
git clone +url-del-repository tra tag

cd + nome-della-cartella tra tag

## Build del progetto  
  bash
  ./gradlew buid

## Esecuzione
 bash
 ./gradlew run

## Architettura
Il progetto è organizzato in layer, seguendo il principio di dependency inversion:

domain --> entità di dominio pure senza dipendenze da UI o persistenza (es.Player,Enemy..)

application--> servizi applicativi (BattleEngine,GameSession,EnemyFactory..)

persistence--> salvataggio/caricamento (SaveRepository,JsonSaveRepository)

ui--> interfaccia JavaFx(controller,navigazione, FXML)

il dominio non dipende mai dalla persistenza o UI; sono quest'ultimi due layer a dipendere da interfacce definite più in basso,
garantendo che la logica di gioco resti testabile e indipendente dai dettagli di implementazione.

## Principi SOLID applicati (alcuni esempi)
- **SRP**: 'BattleEngine' orchestra il combattimento, ma la logica delle singole azioni (attacco,usa oggetto,fuga) è delegata a classi
  'Action' separate
  
-**OCP**: aggiungere una nuova funzione di combattimento richiede solo una nuova classe che implmenta 'Action', senza modificare
  'BattleEngine'
  
-**DIP**: 'GameSession' dipende dall'interfaccia 'SaveRepository', non dalla sua implementazione concreta (JsonSaveRepository),
  rendendo il sistema di salvataggio sostituibile.
  
-**LSP**: 'Player' ed 'Enemy' esetendono 'AbstractCombatant' senza sovrascrivere il comportamento dei metodi ereditati, aggiungendo
  solo funzionalità proprie- questo garantisce che ogni 'Combatant' sia intercambiabile nel codice di combattimento,
  indipendentemente dal tipo concreto

## Uso di strumenti di Intelligenza Artificiale

Durante lo sviluppo del progetto è stato utilizzato Claude come supporto a:

- Progettazione Archittetturale (organizzazione in layer,scelta di desing patter,dependency injection manuale)
- Revisione del codice  e individuazione di bug
- Chiarimenti su concetti Java/Javafx e sui prinicipi SOLID/clean code
- Debug di errori runtime in particolare relativi alla configurazione Gradle/JavaFx e al caricamento di risorse

La stesura del codice, le scelte di game design, la narrazione e la 
struttura finale del progetto sono opera dell'autore.

## Autore
Diego Sannipoli
