package Kamers;

public abstract class Kamer {

    public final void doorloopKamer() {
        startOpdracht();
        //Voor in de toekomst
    }

    public abstract void startOpdracht();
    public abstract boolean checkAntwoord(String input);
    public abstract String getNaam();
    public abstract Monster getMonster();
}
