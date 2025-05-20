public class Speler {
    private String naam;
    private Kamer huidigeKamer;
    private int kamersGehaald = 0;
    private boolean heeftMonster = false;

    public Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setHuidigeKamer(Kamer kamer) {
        this.huidigeKamer = kamer;
    }

    public Kamer getHuidigeKamer() {
        return huidigeKamer;
    }

    public void voegGehaaldeKamerToe() {
        kamersGehaald++;
    }

    public void status() {
        System.out.println("Naam: " + naam);
        System.out.println("Je bent nu in: " + huidigeKamer.getNaam());
        System.out.println("Aantal kamers gehaald: " + kamersGehaald);
        System.out.println(heeftMonster ? "Je hebt een monster te verslaan!" : "Geen monsters actief.");
    }

    public void setHeeftMonster(boolean heeftMonster) {
        this.heeftMonster = heeftMonster;
    }

    public boolean heeftMonster() {
        return heeftMonster;
    }
}
