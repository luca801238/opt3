package Kamers;

import Strategie.MeerkeuzeVraag;

// user story 9: elke kamer is subklasse
public class KamerBoard extends Kamer {
    private Monster monster = new Monster("Chaos");

    @Override
    public boolean heeftAssistent() {
        return true;
    }

    @Override
    public String getInstructie() {
        return "instructie, scrum board";
    }

    @Override
    public String getMotivatie() {
        return "motivatie, scrum board";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    public KamerBoard() {
        this.strategie = new MeerkeuzeVraag(
                "Wat hoort niet thuis op een Scrum Board?",
                new String[]{
                        "Taken, user stories, epics",
                        "Stakeholder feedback",
                        "Blokkades (impediments)"
                },
                "B"
        );
    }


    @Override
    public String getNaam() {
        return "Scrum Board";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
