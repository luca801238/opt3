package Rooms;
// user story 9: elke kamer is subklasse
import Strategy.MultipleChoiceQuestion;

public class RoomReview extends Room {
    private Monster monster = new Monster("Miscommunicatie");

    public RoomReview() {
        this.strategy = new MultipleChoiceQuestion(
                "Wat is het doel van de Sprint Review?",
                new String[]{
                        "Alleen code nakijken",
                        "Feedback van stakeholders verzamelen",
                        "Nieuwe sprint starten"
                },
                "B"
        );
    }

    @Override
    public String getHint() {
        return "Denk aan wie niet thuis hoort op een scrum team van de vorige vraag.";
    }

    @Override
    public boolean acceptsKeyJoker() {
        return true;
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getName() {
        return "Sprint Review";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}