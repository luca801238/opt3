package Kamers;
// user story 9: elke kamer is subklasse

public class KamerTIA extends Kamer {
    private Monster monster = new Monster("Onbegrip");

    // user story 3: korte opdracht
    // user story 16: alle kamers hebben zelfde functie.

    @Override
    public void startOpdracht() {
        System.out.println("Final Kamer – Waarom Scrum?");
        System.out.println("Wat is het belangrijkste doel van Scrum?");
        System.out.println("A: Zoveel mogelijk meetings houden");
        System.out.println("B: Transparantie, inspectie en aanpassing voor betere samenwerking");
        System.out.println("C: Managers tevreden houden");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("B");
    }

    @Override
    public String getNaam() {
        return "TIA";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
