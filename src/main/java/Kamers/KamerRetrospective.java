package Kamers;
// user story 9: elke kamer is subklasse

import Strategie.MatchingVraag;

public class KamerRetrospective extends Kamer {
    private Monster monster = new Monster("Herhaalde fouten");

    public KamerRetrospective() {
        this.strategie = new MatchingVraag();
    }

    @Override
    public boolean heeftAssistent() {
        return true;
    }

    @Override
    public String getInstructie() {
        return "instructie, sprint retrospective";
    }

    @Override
    public String getMotivatie() {
        return "motivatie, sprint retrospective";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getNaam() {
        return "Sprint Retrospective";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
