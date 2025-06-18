package Rooms;
// user story 9: elke kamer is subklasse
import Strategy.MultipleChoiceQuestion;

public class RoomBoard extends Room {
    private Monster monster = new Monster("Chaos");

    @Override
    public boolean hasAssistent() {
        return true;
    }

    @Override
    public String getHint() {
        return "Denk na over wie het Scrum Board gebruikt en welke elementen bijdragen aan het organiseren van het werk binnen het team.";
    }

    @Override
    public String getInstruction() {
        return "Kijk goed naar wat elk element betekent \n Taken zijn de kleinste onderdelen van werk. \n User stories en epics beschrijven wensen van gebruikers en grotere doelen. \n Blokkades zijn dingen die het team tegenhouden. \n Bedenk nu of stakeholder feedback iets is dat vast onderdeel is van het bord of via andere middelen wordt opgehaald.";
    }

    @Override
    public String getMotivation() {
        return "Je bent al scherp bezig! Ga zo door.";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    public RoomBoard() {
        this.strategy = new MultipleChoiceQuestion(
                "Wat hoort niet thuis op een Scrum Board?",
                new String[]{
                        "Taken, user stories, epics",
                        "Stakeholder feedback",
                        "Blokkades"
                },
                "B"
        );
    }

    @Override
    public String getName() {
        return "Scrum Board";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}