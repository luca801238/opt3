package Kamers;

public class KamerBoard extends Kamer {
    private Monster monster = new Monster("Chaos");

    @Override
    public void startOpdracht() {
        System.out.println("Scrum Board:");
        System.out.println("Wat hoort niet thuis op een Scrum Board?");
        System.out.println("A: Taken, user stories, epics");
        System.out.println("B: Stakeholder feedback");
        System.out.println("C: Blokkades (impediments)");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("B");
    }

    @Override
    public String getNaam() {
        return "Scrum Board";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
