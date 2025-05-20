import java.util.Scanner;

public class KamerPlanning extends Kamer {
    private Monster monster = new Monster("Scope Creep");

    @Override
    public void startOpdracht() {
        System.out.println("Sprint Planning: Kies de juiste taken.");
        System.out.println("Welke taken passen in een sprint van 2 weken?");
        System.out.println("A: 50 taken | B: 5 taken | C: 500 taken");
    }

    @Override
    public boolean checkAntwoord(String input) {
        boolean juist = input.trim().equalsIgnoreCase("B");
        notifyObservers(juist); // Observer updates activeren
        return juist;
    }

    @Override
    public String getNaam() {
        return ("Sprint Planning");
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}