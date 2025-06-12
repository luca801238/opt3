package Kamers;
// user story 9: elke kamer is subklasse

import Strategie.OpenVraag;

public class KamerPlanning extends Kamer {
    private Monster monster = new Monster("Scope Creep");

    public KamerPlanning() {
        this.strategie = new OpenVraag(
                "Hoeveel taken zou je idealiter kiezen voor een sprint van 2 weken?",
                "5"
        );
    }

    @Override
    public boolean heeftAssistent() {
        return true;
    }

    @Override
    public String getInstructie() {
        return "instructie, sprint planning";
    }

    @Override
    public String getMotivatie() {
        return "motivatie, sprint planning";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getNaam() {
        return "Sprint Planning";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
