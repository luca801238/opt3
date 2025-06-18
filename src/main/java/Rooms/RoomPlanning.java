package Rooms;
// user story 9: elke kamer is subklasse
import Strategy.OpenQuestion;

public class RoomPlanning extends Room {
    private Monster monster = new Monster("Scope Creep");

    public RoomPlanning() {
        this.strategy = new OpenQuestion(
                "Hoeveel taken zou je idealiter kiezen voor een sprint van 2 weken?",
                "5"
        );
    }

    @Override
    public boolean hasAssistent() {
        return true;
    }

    @Override
    public String getHint() {
        return "Denk niet alleen aan hoeveel taken je kunt doen, maar aan hoeveel je betrouwbaar kunt afronden met het hele team in 2 weken. Kwaliteit boven kwantiteit.";
    }

    @Override
    public String getInstruction() {
        return "Een sprint van 2 weken duurt meestal 10 werkdagen. \n Een user story bevat meestal rond de 4 taken. \n Het is mogelijk om rond de 2 taken per dag uit te voeren.";
    }

    @Override
    public String getMotivation() {
        return "Je zat er niet ver vandaan. Denk nog eens goed na.";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getName() {
        return "Sprint Planning";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}