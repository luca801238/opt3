import Kamers.Kamer;
import java.util.*;

public class Speler {
    private Kamer huidigeKamer;
    private int kamersGehaald = 0;
    private boolean heeftMonster = false;
    private String naam;
    private int keys = 0;
    private int hintJokers = 0;
    private int keyJokers = 0;

    public void giveKey() {
        keys++;
        System.out.println("+1 Sleutel");
        System.out.println("Totaal aantal sleutels: " + keys);
    }

    public void addHintJoker () {
        hintJokers++;
        System.out.println("+1 Hint Joker");
        System.out.println("Totaal aantal Hint Jokers: " + hintJokers);
    }

    public void addKeyJoker () {
        keyJokers++;
        System.out.println("+1 Key Joker");
        System.out.println("Totaal aantal Key Jokers: " + keyJokers);
    }

    public void removeHintJoker () {
        hintJokers--;
        System.out.println("Totaal aantal Hint Jokers: " + hintJokers);
    }

    public void removeKeyJoker () {
        keyJokers--;
        System.out.println("Totaal aantal Key Jokers: " + keyJokers);
    }

    public int getHintJokers() {
        return hintJokers;
    }

    public int getKeyJokers() {
        return keyJokers;
    }

    public Speler(String naam) {
        this.naam = naam;
    }

    private List<Voorwerp> inventaris = new ArrayList<>();

    public List<Voorwerp> getInventaris() {
        return inventaris;
    }

    public void voegVoorwerpToe(Voorwerp v) {
        inventaris.add(v);
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
