package Rooms;
// user story 9: elke kamer is subklasse
import Strategy.MultipleChoiceQuestion;

public class RoomTIA extends Room {
    private Monster monster = new Monster("Onbegrip");

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    public RoomTIA() {
        this.strategy = new MultipleChoiceQuestion(
                "Wat is het belangrijkste doel van Scrum?",
                new String[]{
                        "Zoveel mogelijk meetings houden",
                        "Transparantie, inspectie en aanpassing voor betere samenwerking",
                        "Managers tevreden houden"
                },
                "B"
        );
    }

    @Override
    public String getHint() {
        return "Het langste antwoord, is vaak de juiste.";
    }

    @Override
    public String getName() {
        return "TIA";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}