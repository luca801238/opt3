package Kamers;

// user story 9: elke kamer is subklasse
public class KamerBoard extends Kamer {
    private Monster monster = new Monster("Chaos");

    @Override
    public boolean heeftAssistent() {
        return true;
    }

    @Override
    public String getInstructie() {
        return "instructie, scrum board";
    }

    @Override
    public String getMotivatie() {
        return "motivatie, scrum board";
    }

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.
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
