import java.util.*;
import java.util.Scanner;

public class SpelController {
    private Speler speler;
    private final List<Kamer> kamers;
    private int huidigeKamerIndex;
    private boolean opdrachtGestart = false;
    private final Set<Integer> voltooideKamers = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);

    public SpelController() {
        System.out.print("Voer je naam in: ");
        String naam = scanner.nextLine().trim();

        huidigeKamerIndex = SpelerDAO.laadHuidigeKamer(naam);
        speler = new Speler(naam);

        kamers = List.of(
                new KamerPlanning(),
                new KamerScrum(),
                new KamerBoard(),
                new KamerReview(),
                new KamerRetrospective(),
                new KamerTIA()
        );

        speler.setHuidigeKamer(kamers.get(huidigeKamerIndex));
    }

    public void verwerkCommando(String input) {
        if (CommandoParser.isGaNaarKamer(input)) {
            while (!input.matches(".*\\d.*")) {
                System.out.println("Type naar welke kamer je wilt gaan.");
                input = scanner.nextLine();
            }

            int gevraagdNummer = CommandoParser.haalopKamernummer(input);
            verwerkKamerNavigatie(gevraagdNummer);
        } else if (input.equalsIgnoreCase("status")) {
            speler.status();
        } else {
            verwerkOpdracht(input);
        }
    }

    private void verwerkKamerNavigatie(int gevraagdNummer) {
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
    }

    private void verwerkOpdracht(String input) {
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
