package Rooms;

import Strategy.QuestionStrategy;

// user story 8: abstracte kamer klasse
public abstract class Room {

    protected QuestionStrategy strategy;

    public final void doorloopKamer(int kamerNummer) {
        System.out.println("Je betreedt kamer " + kamerNummer + ": " + getName());
        startTask();
    }

        public void startTask() {
        strategy.startTask();
    }

    public boolean checkAnswer(String input) {
        return strategy.checkAnswer(input);
    }

    public boolean acceptsKeyJoker() {
        return false;
    }

    public boolean hasAssistent() {
        return false;
    }

    public String getHint() {
        return "";
    }

    public String getInstruction() {
        return "";
    }

    public String getMotivation() {
        return "";
    }

    public abstract String getName();
    public abstract Monster getMonster();
}
