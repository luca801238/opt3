package Kamers;

// user story 10: monster klasse
public class Monster {
    private String naam;
    private Actie actie;

    public interface Actie {
        void voerUit(String naam);
        void verberg(String naam);
    }

    private static class StandaardActie implements Actie {
        @Override
        public void voerUit(String naam) {
            System.out.println("Monster verschenen: " + naam);
            System.out.println("Los eerst de opdracht correct op om door te mogen!");
        }

        @Override
        public void verberg(String naam) {
            System.out.println("Monster " + naam + " is verslagen en verdwenen!");
        }
    }

    public Monster(String naam) {
        this.naam = naam;
        this.actie = new StandaardActie();
    }

    public Monster(String naam, Actie actie) {
        this.naam = naam;
        this.actie = actie;
    }

    public void toonMonster() {
        actie.voerUit(naam);
    }

    public void verbergMonster() {
        actie.verberg(naam);
    }
}
