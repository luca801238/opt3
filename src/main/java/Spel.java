// Spel.java – eindigt automatisch na laatste kamer
import java.util.*;

public class Spel {
    private Speler speler;
    private Scanner scanner;
    private List<Kamer> kamers;
    private int huidigeKamerIndex = 0;
    private boolean opdrachtGestart = false;
    private Set<Integer> voltooideKamers = new HashSet<>();

    public Spel() {
        speler = new Speler();
        scanner = new Scanner(System.in);

        kamers = new ArrayList<>();
        kamers.add(new KamerPlanning());
        kamers.add(new KamerScrum());
        kamers.add(new KamerBoard());
        kamers.add(new KamerReview());
        kamers.add(new KamerRetrospective());
        kamers.add(new KamerTIA());

        speler.setHuidigeKamer(kamers.get(huidigeKamerIndex));
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setOpdrachtGestart(boolean gestart) {
        this.opdrachtGestart = gestart;
    }

    public void verwerkCommando(String input) {
        if (input.startsWith("ga naar kamer")) {
            int gevraagdNummer = Integer.parseInt(input.replaceAll("\\D+", ""));

            if (!speler.heeftMonster() && voltooideKamers.contains(huidigeKamerIndex)
                    && gevraagdNummer == huidigeKamerIndex + 2
                    && gevraagdNummer <= kamers.size()) {

                huidigeKamerIndex++;

                if (voltooideKamers.contains(huidigeKamerIndex)) {
                    System.out.println("Deze kamer is al afgerond. Je kunt niet terug.");
                    return;
                }

                speler.setHuidigeKamer(kamers.get(huidigeKamerIndex));
                opdrachtGestart = false;
                System.out.println("Je bent nu in kamer " + (huidigeKamerIndex + 1) + ": " + speler.getHuidigeKamer().getNaam());
                speler.getHuidigeKamer().startOpdracht();
                opdrachtGestart = true;
            } else if (!voltooideKamers.contains(huidigeKamerIndex) && input.startsWith("ga naar kamer")) {
                System.out.println("Je moet eerst de kamer voltooien voordat je verder kan!");
            }

            else {
                System.out.println("Je kunt alleen naar de volgende kamer gaan: 'ga naar kamer " + (huidigeKamerIndex + 2) + "'");
            }
            return;
        }

        if (input.equalsIgnoreCase("status")) {
            speler.status();
            return;
        }

        if (voltooideKamers.contains(huidigeKamerIndex)) {
            System.out.println("Je hebt deze kamer al afgerond. Typ 'ga naar kamer " + (huidigeKamerIndex + 2) + "' om verder te gaan.");
            return;
        }

        if (speler.heeftMonster()) {
            if (speler.getHuidigeKamer().checkAntwoord(input)) {
                System.out.println("Goed beantwoord! Monster verslagen.");
                speler.setHeeftMonster(false);
                speler.voegGehaaldeKamerToe();
                voltooideKamers.add(huidigeKamerIndex);
                opdrachtGestart = false;
            } else {
                System.out.println("Nog steeds fout. Probeer opnieuw.");
            }
            return;
        }

        if (!opdrachtGestart) {
            speler.getHuidigeKamer().startOpdracht();
            opdrachtGestart = true;
        } else {
            if (speler.getHuidigeKamer().checkAntwoord(input)) {
                System.out.println("Goed gedaan! Je mag door naar de volgende kamer.");
                speler.setHeeftMonster(false);
                speler.voegGehaaldeKamerToe();
                voltooideKamers.add(huidigeKamerIndex);
                opdrachtGestart = false;

                if (huidigeKamerIndex == kamers.size() - 1) {
                    System.out.println("Je hebt alle kamers doorlopen en het spel uitgespeeld! Goed gedaan!");
                    System.exit(0);
                }
            } else {
                speler.setHeeftMonster(true);
                speler.getHuidigeKamer().getMonster().toonMonster();
            }
        }
    }
}