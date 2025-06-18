import java.util.Scanner;

// user story 6: spel klasse
public class Game {
    private final GameController controller;
    private Scanner scanner;

    public Game() {
        this.controller = new GameController();
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welkom bij Scrum Escape!");
        controller.chooseStartJoker();
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            controller.processCommand(input);
        }
    }
}