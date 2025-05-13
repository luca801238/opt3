public class KamerTIA extends Kamer {
    private Monster monster = new Monster("Onbegrip");

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
        return "Final TIA Kamer";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
