package Kamers;
// user story 9: elke kamer is subklasse
import Strategie.MeerkeuzeVraag;

public class KamerReview extends Kamer {
    private Monster monster = new Monster("Miscommunicatie");

    public KamerReview() {
        this.strategie = new MeerkeuzeVraag(
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
    public boolean accepteertKeyJoker() {
        return true;
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getNaam() {
        return "Sprint Review";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
