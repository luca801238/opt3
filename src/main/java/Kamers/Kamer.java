package Kamers;

import Strategie.VraagStrategie;

// user story 8: abstracte kamer klasse
public abstract class Kamer {

    protected VraagStrategie strategie;

    public void setVraagStrategie(VraagStrategie strategie) {
        this.strategie = strategie;
    }

    public void startOpdracht() {
        strategie.startOpdracht();
    }

    public boolean checkAntwoord(String input) {
        return strategie.checkAntwoord(input);
    }

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

    public abstract String getNaam();
    public abstract Monster getMonster();
}
