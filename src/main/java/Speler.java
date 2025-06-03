import Kamers.Kamer;

public class Speler {
    private Kamer huidigeKamer;
    private int kamersGehaald = 0;
    private boolean heeftMonster = false;
    private String naam;

    public Speler(String naam) {
        this.naam = naam;
    }

    public void setHuidigeKamer(Kamer kamer) {
        this.huidigeKamer = kamer;
    }

    public Kamer getHuidigeKamer() {
        return huidigeKamer;
    }

    public void setKamersGehaald(int aantal) {
        this.kamersGehaald = aantal;
    }

    public int getKamersGehaald() {
        return kamersGehaald;
    }

    public void voegGehaaldeKamerToe() {
        kamersGehaald++;
    }

    // user story 4: status commando voortgang
    // user story 7: positie en status (samengevoegd)
    public void status() {
        System.out.println("Je bent nu in: " + huidigeKamer.getNaam());
        System.out.println("Aantal kamers gehaald: " + kamersGehaald);
        if (heeftMonster) {
            System.out.println("Je hebt een monster te verslaan!");
        } else {
            System.out.println("Geen monsters actief.");
        }
    }

    public void setHeeftMonster(boolean heeftMonster) {
        this.heeftMonster = heeftMonster;
    }

    public boolean heeftMonster() {
        return heeftMonster;
    }

    public String getNaam() {
        return naam;
    }
}

    public Kamer getHuidigeKamer() {
        return huidigeKamer;
    }

    public void setKamersGehaald(int aantal) {
        this.kamersGehaald = aantal;
    }

    public int getKamersGehaald() {
        return kamersGehaald;
    }

    public void voegGehaaldeKamerToe() {
        kamersGehaald++;
    }

    // user story 4: status commando voortgang
    // user story 7: positie en status (samengevoegd)
    public void status() {
        System.out.println("Je bent nu in: " + huidigeKamer.getNaam());
        System.out.println("Aantal kamers gehaald: " + kamersGehaald);
        if (heeftMonster) {
            System.out.println("Je hebt een monster te verslaan!");
        } else {
            System.out.println("Geen monsters actief.");
        }
    }

    public void setHeeftMonster(boolean heeftMonster) {
        this.heeftMonster = heeftMonster;
    }

    public boolean heeftMonster() {
        return heeftMonster;
    }

    public String getNaam() {
        return naam;
    }
}