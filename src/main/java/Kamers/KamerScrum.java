package Kamers;

import Strategie.MeerkeuzeVraag;

// user story 9: elke kamer is subklasse

public class KamerScrum extends Kamer {
    private Monster monster = new Monster("Vertraging");
    private final String assistentInstructie = "Gebruik de 'Start, Stop, Continue'-techniek.";
    private final String assistentMotivatie = "Je groeit als een echte teamspeler!";

    public KamerScrum() {
        this.strategie = new MeerkeuzeVraag(
                "Vraag: Wat zeg je tijdens een Daily Scrum?",
                new String[]{
                        "A. Wat ik gisteren heb gegeten",
                        "B. Wat ik gisteren heb gedaan, wat ik vandaag ga doen en of ik blokkades heb",
                        "C. Wat ik van het weer vond"
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
        return "Daily Scrum";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
