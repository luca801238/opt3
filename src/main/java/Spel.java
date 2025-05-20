import java.util.*;
import java.sql.*;

public class Spel {
    private Speler speler;
    private Scanner scanner;
    private List<Kamer> kamers;
    private int huidigeKamerIndex = 0;
    private boolean opdrachtGestart = false;
    private Set<Integer> voltooideKamers = new HashSet<>();

    public Spel() {
        scanner = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String naam = scanner.nextLine();
        speler = new Speler(naam);

        kamers = new ArrayList<>();
        kamers.add(new KamerPlanning());
        kamers.add(new KamerScrum());
        kamers.add(new KamerBoard());
        kamers.add(new KamerReview());
        kamers.add(new KamerRetrospective());
        kamers.add(new KamerTIA());

        huidigeKamerIndex = SpelerDAO.laadHuidigeKamer(naam);
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

                SpelerDAO.slaOp(speler.getNaam(), huidigeKamerIndex);
            } else if (!voltooideKamers.contains(huidigeKamerIndex)) {
                System.out.println("Je moet eerst de kamer voltooien voordat je verder kan!");
            } else {
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

                SpelerDAO.slaOp(speler.getNaam(), huidigeKamerIndex);
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

                SpelerDAO.slaOp(speler.getNaam(), huidigeKamerIndex);

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
