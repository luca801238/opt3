public class Zwaard implements Voorwerp {
    private boolean alGebruikt = false;

    @Override
    public void gebruik(Speler speler) {
        if (alGebruikt) {
            System.out.println("Je hebt het zwaard al gebruikt in deze kamer!");
            return;
        }

        if (speler.heeftMonster()) {
            System.out.println("Je hebt het zwaard gebruikt om het monster te verslaan!");
            speler.setHeeftMonster(false);
            speler.voegGehaaldeKamerToe();
            alGebruikt = true;
        } else {
            System.out.println("Er is geen monster actief.");
        }
    }
}
