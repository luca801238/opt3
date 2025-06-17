package Rooms;

import Strategy.MultipleChoiceQuestion;

// user story 9: elke kamer is subklasse

public class RoomScrum extends Room {
    private Monster monster = new Monster("Vertraging");
    private final String assistentInstructie = "Gebruik de 'Start, Stop, Continue'-techniek.";
    private final String assistentMotivatie = "Je groeit als een echte teamspeler!";

    public RoomScrum() {
        this.strategy = new MultipleChoiceQuestion(
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
    public String getHint() {
        return "Wat klinkt werk gerelateerd?";
    }

    @Override
    public boolean acceptsKeyJoker() {
        return true;
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public String getName() {
        return "Daily Scrum";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
