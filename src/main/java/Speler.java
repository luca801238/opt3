import Kamers.Kamer;

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

    public void setHuidigeKamer(Kamer kamer) {
        this.huidigeKamer = kamer;
    }
