package Kamers;
// user story 9: elke kamer is subklasse

public class KamerScrum extends Kamer {
    private Monster monster = new Monster("Vertraging");

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public void startOpdracht() {
        System.out.println("Daily Scrum:");
        System.out.println("Vraag: Wat zeg je tijdens een Daily Scrum?");
        System.out.println("A: Wat ik gisteren heb gegeten");
        System.out.println("B: Wat ik gisteren heb gedaan, wat ik vandaag ga doen en of ik blokkades heb");
        System.out.println("C: Wat ik van het weer vond");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("B");
    }

    @Override
    public String getNaam() {
        return "Daily Scrum";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
