import java.util.Scanner;

// user story 6: spel klasse
public class Spel {
    private final SpelController controller;
    private Scanner scanner;
    

    public Spel() {
        this.controller = new SpelController();
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welkom bij Scrum Escape!");
        controller.kiesStartJoker();
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            controller.verwerkCommando(input);
        }
    }
}