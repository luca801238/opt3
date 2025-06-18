package Rooms;
// user story 9: elke kamer is subklasse
import Strategy.MatchingQuestion;

public class RoomRetrospective extends Room {
    private Monster monster = new Monster("Herhaalde fouten");

    public RoomRetrospective() {
        this.strategy = new MatchingQuestion();
    }

    @Override
    public boolean hasAssistent() {
        return true;
    }

    @Override
    public String getHint() {
        return "De volgorde is precies zoals het staat.";
    }

    @Override
    public String getInstruction() {
        return "A1 B2 C3";
    }

    @Override
    public String getMotivation() {
        return "Je bent bijna klaar!";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getName() {
        return "Sprint Retrospective";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}