package Kamers;

// user story 8: abstracte kamer klasse
public abstract class Kamer {

    public boolean accepteertKeyJoker() {
        return false;
    }

    public boolean heeftAssistent() {
        return false;
    }

    public String getInstructie() {
        return "";
    }

    public String getMotivatie() {
        return "";
    }

    public final void doorloopKamer() {
        startOpdracht();
        //Voor in de toekomst
    }

    public abstract void startOpdracht();
    public abstract boolean checkAntwoord(String input);
    public abstract String getNaam();
    public abstract Monster getMonster();
}
