public class Speler {
    private Kamer huidigeKamer;
    private int kamersGehaald = 0;
    private boolean heeftMonster = false;

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
        System.out.println("🧍 Je bent nu in: " + huidigeKamer.getNaam());
        System.out.println("✅ Aantal kamers gehaald: " + kamersGehaald);
        if (heeftMonster) {
            System.out.println("⚠️ Je hebt een monster te verslaan!");
        } else {
            System.out.println("🎉 Geen monsters actief.");
        }
    }

    public void setHeeftMonster(boolean heeftMonster) {
        this.heeftMonster = heeftMonster;
    }

    public boolean heeftMonster() {
        return heeftMonster;
    }
}
