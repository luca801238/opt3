public class Monster {
    private String naam;

    public Monster(String naam) {
        this.naam = naam;
    }

    public void toonMonster() {
        System.out.println("👹 Monster verschenen: " + naam);
        System.out.println("Los eerst de opdracht correct op om door te mogen!");
    }
}
