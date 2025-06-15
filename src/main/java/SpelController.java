import Kamers.*;
import Observers.AntwoordController;

import java.util.*;
import java.util.Scanner;

public class SpelController {
    private Speler speler;
    private final List<Kamer> kamers;
    private int huidigeKamerIndex;
    private boolean opdrachtGestart = false;
    private final Set<Integer> voltooideKamers = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);
    private final AntwoordController antwoordController = new AntwoordController();


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
        speler.voegVoorwerpToe(new Kamerinfo());
        speler.voegVoorwerpToe(new Zwaard());
    }

    public void kiesStartJoker() {
        System.out.println("Kies een joker om mee te beginnen:");
        System.out.println("1. Hint Joker (voor hulp bij opdrachten)");
        System.out.println("2. Key Joker (voor een sleutel in bepaalde kamers)");
        String keuze = scanner.nextLine().trim();

        switch (keuze) {
            case "1":
                speler.addHintJoker();
                System.out.println("Je hebt een Hint Joker gekregen.");
                System.out.println("Typ 'ga door' om door te gaan.");
                break;
            case "2":
                speler.addKeyJoker();
                System.out.println("Je hebt een Key Joker gekregen.");
                System.out.println("Typ 'ga door' om door te gaan.");
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                kiesStartJoker();
                break;
        }
    }

    // verwerkt de commandos, user story 4
    public void verwerkCommando(String input) {
        if (Commandos.isGaNaarKamer(input)) {
            while (!Commandos.bevatGetal(input)) {
                System.out.println("Ongeldige invoer. Type een geldig kamernummer, bijvoorbeeld 'Ga naar kamer 3'.");
                input = scanner.nextLine();
            }

            int gevraagdNummer = Commandos.haalopKamernummer(input);
            verwerkKamerNavigatie(gevraagdNummer);
        }
        else if (input.equalsIgnoreCase("status")) {
            speler.status();
        }
        else if (input.equalsIgnoreCase("assistent")) {
            gebruikAssistent();
        }
        else if (input.toLowerCase().startsWith("gebruik")) {
            String naam = input.substring(7).trim().toLowerCase();

            Optional<Voorwerp> gevonden = speler.getInventaris().stream()
                    .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(naam))
                    .findFirst();

            if (gevonden.isPresent()) {
                gevonden.get().gebruik(speler);
            } else {
                System.out.println("Je hebt dit voorwerp niet.");
            }
        }
        else {
            verwerkOpdracht(input);
        }
    }

    // user story 2: kamers wisselen
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
            vraagGebruikKeyJoker();
            speler.getHuidigeKamer().startOpdracht();
            opdrachtGestart = true;

            SpelerDAO.slaOp(speler.getNaam(), huidigeKamerIndex);
        } else if (!voltooideKamers.contains(huidigeKamerIndex)) {
            System.out.println("Je moet eerst de kamer voltooien voordat je verder kan!");
        } else {
            System.out.println("Je kunt alleen naar de volgende kamer gaan: 'ga naar kamer " + (huidigeKamerIndex + 2) + "'");
        }
    }

    // user story 2: kamers wisselen
    private void verwerkOpdracht(String input) {


        if (voltooideKamers.contains(huidigeKamerIndex)) {
            System.out.println("Je hebt deze kamer al afgerond. Typ 'ga naar kamer " + (huidigeKamerIndex + 2) + "' om verder te gaan.");
            return;
        }

        if (speler.heeftMonster()) {
            if (speler.getHuidigeKamer().checkAntwoord(input)) {
                speler.getHuidigeKamer().getMonster().verbergMonster();
                speler.setHeeftMonster(false);

                markeerKamerAlsVoltooid();

                if (huidigeKamerIndex == kamers.size() - 1) {
                    eindPrompt();
                }
            }
            else {
                System.out.println("Nog steeds fout. Probeer opnieuw.");
                vraagHint();
            }
            return;
        }

        if (!opdrachtGestart) {
            speler.getHuidigeKamer().startOpdracht();
            opdrachtGestart = true;
        } else {
            if (speler.getHuidigeKamer().checkAntwoord(input)) {
                System.out.println("Goed gedaan! Je mag door naar de volgende kamer.");
                System.out.println("Typ 'ga naar kamer " + (huidigeKamerIndex + 2) + "'.");
                speler.setHeeftMonster(false);
                markeerKamerAlsVoltooid();

                if (huidigeKamerIndex == kamers.size() - 1) {
                    eindPrompt();
                }
            } else {
                speler.setHeeftMonster(true);
                speler.getHuidigeKamer().getMonster().toonMonster();
                vraagHint();
            }
        }
    }
    // user story 2: kamers wisselen
    private void eindPrompt() {

        System.out.println("Je hebt alle kamers doorlopen en het spel uitgespeeld! Goed gedaan!");
        System.out.println("Wil je opnieuw spelen? Zeg ja/nee:");

        while (true) {

            String keuze = scanner.nextLine();

            if (keuze.equalsIgnoreCase("ja")) {
                System.out.println("Al je voortgang wordt nu gereset, je kan het spel opnieuw spelen! \n");

                huidigeKamerIndex = 0;
                speler.setHuidigeKamer(kamers.get(huidigeKamerIndex));
                speler.setHeeftMonster(false);
                voltooideKamers.clear();

                SpelerDAO.slaOp(speler.getNaam(), 0);

                speler.getHuidigeKamer().startOpdracht();
                opdrachtGestart = true;
                break;
            }

            if (keuze.equalsIgnoreCase("nee")) {
                System.out.println("Bedankt voor het spelen!");
                System.exit(0);
            }

            System.out.println("Ongeldige invoer. Typ 'ja' of 'nee'.");
        }
    }

    // user story 20 - hint
    private void vraagHint() {
        if (speler.getHintJokers() > 0) {
            System.out.println("Wil je een hint gebruiken? (ja/nee)");
            String keuze = scanner.nextLine().trim().toLowerCase();

            if (keuze.equals("ja")) {
                toonHint();
            } else {
                System.out.println("Oké, geen hint. Probeer het opnieuw!");
            }
        }
    }

    public void toonHint() {
        Joker hintJoker = new HintJoker();
        hintJoker.useJoker(speler);
    }

    private void vraagGebruikKeyJoker() {
        if (speler.getKeyJokers() > 0 && speler.getHuidigeKamer().accepteertKeyJoker()) {
            System.out.println("Wil je een Key Joker gebruiken om een sleutel te krijgen? (ja/nee)");
            String keuze = scanner.nextLine().trim().toLowerCase();

            if (keuze.equals("ja")) {
                Joker keyJoker = new KeyJoker();
                keyJoker.useJoker(speler);
            } else {
                System.out.println("Geen Key Joker gebruikt.");
            }
        }
    }

    // user story 24
    private void gebruikAssistent() {
        Kamer kamer = speler.getHuidigeKamer();

        if (kamer.heeftAssistent()) {
            Assistent assistent = new Assistent();
            assistent.gebruik(speler);
        } else {
            System.out.println("Geen assistent beschikbaar voor deze kamer.");
        }
    }



    // SHOTGUN SURGERY VOORKOMEN!!!
    private void markeerKamerAlsVoltooid() {
        speler.voegGehaaldeKamerToe();
        voltooideKamers.add(huidigeKamerIndex);
        opdrachtGestart = false;
        SpelerDAO.slaOp(speler.getNaam(), huidigeKamerIndex);
    }
}