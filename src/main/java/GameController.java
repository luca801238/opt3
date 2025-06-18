import Rooms.*;
import Observers.*;
import java.util.*;
import java.util.Scanner;
import Player.Player;
import Player.PlayerDAO;
import items.Usable;

public class GameController {
    private Player player;
    private final List<Room> rooms;
    private int currentRoomIndex;
    private boolean taskStarted = false;
    private final Set<Integer> completedRooms = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);
    private final AnswerController answerController = new AnswerController();
    private final MonsterObserver monsterObserver;
    public GameController() {

        System.out.print("Voer je naam in: ");
        String naam = scanner.nextLine().trim();

        currentRoomIndex = PlayerDAO.loadCurrentRoom(naam);
        player = new Player(naam);



        rooms = List.of(
                new RoomPlanning(),
                new RoomScrum(),
                new RoomBoard(),
                new RoomReview(),
                new RoomRetrospective(),
                new RoomTIA()
        );

        monsterObserver = new MonsterObserver(null);


        answerController.voegObserverToe(new DeurObserver());
        Status status = new Status();
        answerController.voegObserverToe(status);
        answerController.voegObserverToe(monsterObserver);

        player.setCurrentRoom(rooms.get(currentRoomIndex));
        monsterObserver.setRoom(player.getCurrentRoom());

        player.addObject(new Kamerinfo());
        player.addObject(new Zwaard());






    }

    public void chooseStartJoker() {
        System.out.println("Kies een joker om mee te beginnen:");
        System.out.println("1. Hint Joker (voor hulp bij opdrachten)");
        System.out.println("2. Key Joker (voor een sleutel in bepaalde kamers)");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                player.addHintJoker();
                System.out.println("Je hebt een Hint Joker gekregen.");
                System.out.println("Typ 'ga door' om door te gaan.");
                break;
            case "2":
                player.addKeyJoker();
                System.out.println("Je hebt een Key Joker gekregen.");
                System.out.println("Typ 'ga door' om door te gaan.");
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                chooseStartJoker();
                break;
        }
    }

    // verwerkt de commands, user story 4
    public void processCommand(String input) {
        if (Commands.isGoToRoom(input)) {
            while (!Commands.containsNumber(input)) {
                System.out.println("Ongeldige invoer. Type een geldig kamernummer, bijvoorbeeld 'Ga naar kamer 3'.");
                input = scanner.nextLine();
            }

            int askedNummer = Commands.getRoomNumber(input);
            processNavigation(askedNummer);
        }
        else if (input.equalsIgnoreCase("status")) {
            player.status();
        }
        else if (input.equalsIgnoreCase("assistent")) {
            useAssistent();
        }
        else if (input.toLowerCase().startsWith("gebruik")) {
            String name = input.substring(7).trim().toLowerCase();

            Optional<Usable> found = player.getInventory().stream()
                    .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(name))
                    .findFirst();

            if (found.isPresent()) {
                found.get().use(player);
            } else {
                System.out.println("Je hebt dit voorwerp niet.");
            }
        }
        else if (input.equalsIgnoreCase("ga door")) {
            if (!taskStarted) {
                startTask();
            } else {
                System.out.println("Je bent al bezig met de opdracht.");
            }
        }

        else {
            processTask(input);
        }
    }

    // user story 2: kamers wisselen
    private void processNavigation(int askedNumber) {
        if (!player.getHasMonster() && completedRooms.contains(currentRoomIndex)
                && askedNumber == currentRoomIndex + 2
                && askedNumber <= rooms.size()) {

            currentRoomIndex++;

            if (completedRooms.contains(currentRoomIndex)) {
                System.out.println("Deze kamer is al afgerond. Je kunt niet terug.");
                return;
            }

            player.setCurrentRoom(rooms.get(currentRoomIndex));
            monsterObserver.setRoom(player.getCurrentRoom());

            taskStarted = false;
            System.out.println("Je bent nu in kamer " + (currentRoomIndex + 1) + ": " + player.getCurrentRoom().getName());
            askUseKeyJoker();
            startTask();

            PlayerDAO.save(player.getName(), currentRoomIndex);
        } else if (!completedRooms.contains(currentRoomIndex)) {
            System.out.println("Je moet eerst de kamer voltooien voordat je verder kan!");
        } else {
            System.out.println("Je kunt alleen naar de volgende kamer gaan: 'ga naar kamer " + (currentRoomIndex + 2) + "'");
        }
    }

    // user story 2: kamers wisselen
    private void processTask(String input) {
        if (completedRooms.contains(currentRoomIndex)) {
            System.out.println("Je hebt deze kamer al afgerond. Typ 'ga naar kamer " + (currentRoomIndex + 2) + "' om verder te gaan.");
            return;
        }

        if (!taskStarted) {
            System.out.println("Typ 'ga door' om te beginnen met de opdracht.");
            return;
        }

        boolean correct = player.getCurrentRoom().checkAnswer(input);

        if (correct) {
            if (player.getHasMonster()) {
                answerController.verwerkAntwoord(true);
            } else {
                answerController.verwerkAntwoordZonderMonster(true);
            }
            processCorrectAnswer();
        } else {
            if (!player.getHasMonster()) {
                player.setHasMonster(true);
                //player.getCurrentRoom().getMonster().showMonster();
            }
            answerController.verwerkAntwoord(correct);
            questionHint();
        }
    }
    // user story 2: kamers wisselen
    private void endPrompt() {

        System.out.println("Je hebt alle kamers doorlopen en het spel uitgespeeld! Goed gedaan!");
        System.out.println("Wil je opnieuw spelen? Zeg ja/nee:");

        while (true) {

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("ja")) {
                System.out.println("Al je voortgang wordt nu gereset, je kan het spel opnieuw spelen! \n");

                currentRoomIndex = 0;
                player.setCurrentRoom(rooms.get(currentRoomIndex));
                monsterObserver.setRoom(player.getCurrentRoom());
                player.setHasMonster(false);
                completedRooms.clear();

                PlayerDAO.save(player.getName(), 0);

                startTask();
                break;
            }

            if (choice.equalsIgnoreCase("nee")) {
                System.out.println("Bedankt voor het spelen!");
                System.exit(0);
            }

            System.out.println("Ongeldige invoer. Typ 'ja' of 'nee'.");
        }
    }

    // user story 20 - hint
    private void questionHint() {
        if (player.getHintJokers() > 0) {
            System.out.println("Wil je een hint gebruiken? (ja/nee)");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("ja")) {
                showHint();
            } else {
                System.out.println("Oké, geen hint. Probeer het opnieuw!");
            }
        }
    }

    public void showHint() {
        Joker hintJoker = new HintJoker();
        hintJoker.useJoker(player);
    }

    private void askUseKeyJoker() {
        if (player.getKeyJokers() > 0 && player.getCurrentRoom().acceptsKeyJoker()) {
            System.out.println("Wil je een Key Joker gebruiken om een sleutel te krijgen? (ja/nee)");
            String keuze = scanner.nextLine().trim().toLowerCase();

            if (keuze.equals("ja")) {
                Joker keyJoker = new KeyJoker();
                keyJoker.useJoker(player);
            } else {
                System.out.println("Geen Key Joker gebruikt.");
            }
        }
    }

    // user story 24
    private void useAssistent() {
        Room room = player.getCurrentRoom();

        if (room.hasAssistent()) {
            Assistent assistent = new Assistent();
            assistent.use(player);
        } else {
            System.out.println("Geen assistent beschikbaar voor deze kamer.");
        }
    }

    // SHOTGUN SURGERY VOORKOMEN!!!
    private void processCorrectAnswer() {
        player.setHasMonster(false);

        player.addCompletedRoom();
        completedRooms.add(currentRoomIndex);
        taskStarted = false;
        PlayerDAO.save(player.getName(), currentRoomIndex);

        if (currentRoomIndex == rooms.size() - 1) {
            endPrompt();
        } else {
            System.out.println("Goed gedaan! Je mag door naar de volgende kamer.");
            System.out.println("Typ 'ga naar kamer " + (currentRoomIndex + 2) + "'.");
        }
    }

    // SHOTGUN SURGERY VOORKOMEN!
    private void startTask() {
        player.getCurrentRoom().startTask();
        taskStarted = true;
    }
}