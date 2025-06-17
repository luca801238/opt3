package Rooms;
// user story 9: elke kamer is subklasse

import Strategy.OpenQuestion;

public class RoomPlanning extends Room {
    private Monster monster = new Monster("Scope Creep");

    public RoomPlanning() {
        this.strategy = new OpenQuestion(
                "Hoeveel taken zou je idealiter kiezen voor een sprint van 2 weken?",
                "5"
        );
    }

    @Override
    public boolean hasAssistent() {
        return true;
    }

    @Override
    public String getHint() {
        return "100 / 20 = ?.";
    }

    @Override
    public String getInstruction() {
        return "instructie, sprint planning";
    }

    @Override
    public String getMotivation() {
        return "motivatie, sprint planning";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getName() {
        return "Sprint Planning";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
