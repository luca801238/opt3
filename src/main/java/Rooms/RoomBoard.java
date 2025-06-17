package Rooms;

import Strategy.MultipleChoiceQuestion;

// user story 9: elke kamer is subklasse
public class RoomBoard extends Room {
    private Monster monster = new Monster("Chaos");

    @Override
    public boolean hasAssistent() {
        return true;
    }

    @Override
    public String getHint() {
        return "Wie hoort niet op een scrum team?";
    }

    @Override
    public String getInstruction() {
        return "instructie, scrum board";
    }

    @Override
    public String getMotivation() {
        return "motivatie, scrum board";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    public RoomBoard() {
        this.strategy = new MultipleChoiceQuestion(
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
    public String getName() {
        return "Scrum Board";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
