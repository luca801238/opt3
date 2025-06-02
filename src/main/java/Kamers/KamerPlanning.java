package Kamers;
// user story 9: elke kamer is subklasse

public class KamerPlanning extends Kamer {
    private Monster monster = new Monster("Scope Creep");

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public void startOpdracht() {
        System.out.println("Sprint Planning: Kies de juiste taken.");
        System.out.println("Welke taken passen in een sprint van 2 weken?");
        System.out.println("A: 50 taken | B: 5 taken | C: 500 taken");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("B");
    }

    @Override
    public String getNaam() {
        return "Sprint Planning";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
