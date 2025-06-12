package Kamers;
// user story 9: elke kamer is subklasse
import Strategie.MeerkeuzeVraag;

public class KamerTIA extends Kamer {
    private Monster monster = new Monster("Onbegrip");

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    public KamerTIA() {
        this.strategie = new MeerkeuzeVraag(
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
    public String getNaam() {
        return "TIA";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
