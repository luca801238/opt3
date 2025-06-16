package Rooms;

import Strategy.QuestionStrategy;

// user story 8: abstracte kamer klasse
public abstract class Room {

    protected QuestionStrategy strategy;

    public void setQuestionStrategy(QuestionStrategy strategy) {
        this.strategy = strategy;
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

    public String getInstruction() {
        return "";
    }

    public String getMotivation() {
        return "";
    }

    public final void passRoom() {
        startTask();
        //Voor in de toekomst
    }

    public abstract String getName();
    public abstract Monster getMonster();
}
