public class KamerReview extends Kamer {
    private Monster monster = new Monster("Miscommunicatie");

    @Override
    public void startOpdracht() {
        System.out.println("🔍 Sprint Review: Feedback verwerken.");
        System.out.println("Wat is het doel van de Sprint Review?");
        System.out.println("A: Alleen code nakijken");
        System.out.println("B: Feedback van stakeholders verzamelen");
        System.out.println("C: Nieuwe sprint starten");
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase("B");
    }

    @Override
    public String getNaam() {
        return "Sprint Review";
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
