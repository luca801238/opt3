package Kamers;

public class KamerRetrospective extends Kamer {
    private Monster monster = new Monster("Herhaalde fouten");

    @Override
    public void startOpdracht() {
        System.out.println("Sprint Retrospective:");
        System.out.println("Wat bespreek je in een retrospective?");
        System.out.println("A: Hoe we kunnen verbeteren als team");
        System.out.println("B: Wie het meeste werk deed");
        System.out.println("C: Wat we gisteren gegeten hebben");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("A");
    }

    @Override
    public String getNaam() {
        return "Sprint Retrospective";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
